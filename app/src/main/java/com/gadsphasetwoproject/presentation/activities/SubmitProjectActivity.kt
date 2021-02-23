package com.gadsphasetwoproject.presentation.activities

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.observe
import com.gadsphasetwoproject.R
import com.gadsphasetwoproject.databinding.ActivitySubmitProjectBinding
import com.gadsphasetwoproject.presentation.utils.CustomProgressDialog
import com.gadsphasetwoproject.presentation.utils.Utils
import com.gadsphasetwoproject.presentation.viewModel.SubmitProjectViewModel
import dagger.hilt.android.AndroidEntryPoint
import es.dmoral.toasty.Toasty
import javax.inject.Inject

@AndroidEntryPoint
class SubmitProjectActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySubmitProjectBinding

    private val viewModel: SubmitProjectViewModel by viewModels()

    @Inject
    lateinit var progressDialog: CustomProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_submit_project)
        progressDialog = CustomProgressDialog(this)
        setSupportActionBar(findViewById(R.id.submit_toolbar))
        getLiveData()
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
            submitProject(
                binding.edtxtEmail.text.toString(),
                binding.edtxtFirstName.text.toString(),
                binding.edtxtLastName.text.toString(),
                binding.edtxtGithubLink.text.toString()
            )
            dialog.dismiss()
        }

        dialog.show()

    }

    private fun submitProject(
        email: String?,
        name: String?,
        lastname: String?,
        link: String?
    ) {
        viewModel.submitProject(
            email,
            name,
            lastname,
            link
        )
    }

    private fun getLiveData() {
        viewModel.getSubmission.observe(this) {
            if (it) {
                progressDialog.hideDialog()
                showSuccessfulDialog()
            } else {
                progressDialog.hideDialog()
                showUnSuccessfulDialog()
            }
        }
        viewModel.getLoading.observe(this) { loading ->
            if (loading) {
                progressDialog.showDialog()
            } else {
                progressDialog.hideDialog()
            }
        }
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