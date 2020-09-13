package com.gadsphasetwoproject.activities

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.gadsphasetwoproject.R
import com.gadsphasetwoproject.databinding.ActivitySubmitProjectBinding
import es.dmoral.toasty.Toasty

class SubmitProjectActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySubmitProjectBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_submit_project)
        setSupportActionBar(findViewById(R.id.submit_toolbar))
        with(binding) {
            backButton.setOnClickListener {
                onBackPressed()
            }

            btnSaveAccount.setOnClickListener {
                showSuccessfulDialog()
            }
        }
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