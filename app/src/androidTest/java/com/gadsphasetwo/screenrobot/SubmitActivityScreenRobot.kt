package com.gadsphasetwo.screenrobot

import com.gadsphasetwoproject.R

class SubmitActivityScreenRobot : ScreenRobot<SubmitActivityScreenRobot>() {
    fun testSubmitButton(): SubmitActivityScreenRobot? {
        return clickOkOnView(R.id.btn_save_account)
    }

}