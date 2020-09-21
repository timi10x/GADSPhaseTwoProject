package com.gadsphasetwoproject.activities

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.gadsphasetwoproject.R
import com.gadsphasetwoproject.databinding.ActivitySubmitProjectBinding
import com.gadsphasetwoproject.networkCalls.ApiInterface
import com.gadsphasetwoproject.utils.CustomProgressDialog
import com.gadsphasetwoproject.utils.Utils
import es.dmoral.toasty.Toasty
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber


class SubmitProjectActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySubmitProjectBinding

    private lateinit var progressDialog: CustomProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_submit_project)
        setSupportActionBar(findViewById(R.id.submit_toolbar))
        progressDialog = CustomProgressDialog(this)
        with(binding) {
            backButton.setOnClickListener {
                onBackPressed()
            }

            btnSaveAccount.setOnClickListener {
                if (Utils.isOnline(this@SubmitProjectActivity)) {
                    if (!validateFields()) {
                        return@setOnClickListener
                    }
                    showConfirmationDialog()
                }
            }
        }
    }

    private fun showConfirmationDialog() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)

        dialog.setContentView(R.layout.confirmation_dialog)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setCancelable(true)
        val cancelBtn: ImageView = dialog.findViewById(R.id.cancelBtn)
        cancelBtn.setOnClickListener {
            dialog.dismiss()
        }

        val yesBtn: Button = dialog.findViewById(R.id.submit_button)
        yesBtn.setOnClickListener {
            submitProject()
            dialog.dismiss()
        }

        dialog.show()

    }

    private fun submitProject() {
        progressDialog.showDialog()
        val apiInterface = ApiInterface.submit().submitProject(
            binding.edtxtEmail.text.toString(),
            binding.edtxtFirstName.text.toString(),
            binding.edtxtLastName.text.toString(),
            binding.edtxtGithubLink.text.toString()
        )

        apiInterface.enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>?, response: Response<Void>?) {
                if (response!!.isSuccessful) {
                    progressDialog.hideDialog()
                    Timber.d("${response.code()}")
                    Toasty.success(
                        this@SubmitProjectActivity,
                        "successfully sent",
                        Toasty.LENGTH_SHORT,
                        true
                    ).show()
                    showSuccessfulDialog()
                }
            }

            override fun onFailure(call: Call<Void>?, t: Throwable?) {
                progressDialog.hideDialog()
                Timber.d("this is the onfailure body ${call.toString()} ${t.toString()}")
                showUnSuccessfulDialog()
            }
        })

    }

    private fun showUnSuccessfulDialog() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)

        dialog.setContentView(R.layout.submission_not_successful_dialog)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setCancelable(true)

        dialog.show()

    }

    private fun showSuccessfulDialog() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)

        dialog.setContentView(R.layout.submission_successful_dialog)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setCancelable(true)

        dialog.show()

    }

    private fun validateFields(): Boolean {
        var isValid = true
        if (binding.edtxtFirstName.text.toString().isEmpty()) {
            binding.edtxtFirstName.requestFocus()
            isValid = false
            Toasty.warning(this, "oops, input your firstname", Toasty.LENGTH_SHORT, true).show()
        } else if (binding.edtxtLastName.text.toString().isEmpty()) {
            binding.edtxtLastName.requestFocus()
            isValid = false
            Toasty.warning(this, "oops, input your lastname", Toasty.LENGTH_SHORT, true).show()
        } else if (binding.edtxtEmail.text.toString()
                .isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(binding.edtxtEmail.text.toString())
                .matches()
        ) {
            binding.edtxtEmail.requestFocus()
            isValid = false
            Toasty.warning(this, "oops, input your email", Toasty.LENGTH_SHORT, true).show()

        } else if (binding.edtxtGithubLink.text.toString().isEmpty()) {
            binding.edtxtGithubLink.requestFocus()
            isValid = false
            Toasty.warning(this, "oops, input your github link", Toasty.LENGTH_LONG, true).show()
        }
        return isValid
    }
}