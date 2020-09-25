package com.gadsphasetwo.screenrobot

import com.gadsphasetwoproject.R

class MainActivityScreenRobot : ScreenRobot<MainActivityScreenRobot>() {

    fun clickSubmitButton(): MainActivityScreenRobot {
        return clickOkOnView(R.id.action_bar_submit)
    }

}