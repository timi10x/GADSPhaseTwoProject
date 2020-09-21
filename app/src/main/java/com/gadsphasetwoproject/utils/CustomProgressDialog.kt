package com.gadsphasetwoproject.utils

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import com.gadsphasetwoproject.R
import javax.inject.Inject


class CustomProgressDialog @Inject constructor(private val activity: Activity) {
    private var dialog: Dialog? = null
    private fun initDialog() {
        dialog = Dialog(activity)
        dialog!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog!!.setCancelable(true)
        if (dialog!!.window != null) {
            dialog!!.window!!
                .setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }

        dialog!!.setContentView(R.layout.custom_progress_dialog)

    }

    fun showDialog() {
        dialog!!.show()
    }

    //..also create a method which will hide the dialog when some work is done
    fun hideDialog() {
        dialog!!.dismiss()
    }

    init {
        initDialog()
    }
}
