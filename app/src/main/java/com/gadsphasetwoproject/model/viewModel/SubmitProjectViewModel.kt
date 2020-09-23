package com.gadsphasetwoproject.model.viewModel

import android.app.Application
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gadsphasetwoproject.R
import com.gadsphasetwoproject.room.repository.SubmitProjectRepository
import com.gadsphasetwoproject.utils.Resource
import kotlinx.coroutines.launch

class SubmitProjectViewModel @ViewModelInject constructor(
    private val repository: SubmitProjectRepository,
    private val application: Application
) : ViewModel() {

    private val context = application.applicationContext
    private fun showUnSuccessfulDialog() {
        val dialog = Dialog(context)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)

        dialog.setContentView(R.layout.submission_not_successful_dialog)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setCancelable(true)

        dialog.show()

    }

    private fun showSuccessfulDialog() {
        val dialog = Dialog(context)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)

        dialog.setContentView(R.layout.submission_successful_dialog)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setCancelable(true)

        dialog.show()

    }

    fun submitProject(
        email: String?,
        name: String?,
        lastname: String?,
        link: String?
    ) {
        viewModelScope.launch {
            val result = repository.submitProject(
                email,
                name,
                lastname,
                link
            )
            when (
                result.status
                ) {
                Resource.Status.SUCCESS -> {
                    showSuccessfulDialog()
                }

                Resource.Status.ERROR -> {
                    showUnSuccessfulDialog()

                }

                Resource.Status.LOADING -> {

                }
            }
        }
    }

}