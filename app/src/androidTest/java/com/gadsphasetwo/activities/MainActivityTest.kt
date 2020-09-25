package com.gadsphasetwo.activities

import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.gadsphasetwo.screenrobot.MainActivityScreenRobot
import com.gadsphasetwo.screenrobot.ScreenRobot.Companion.withRobot
import com.gadsphasetwoproject.R
import com.gadsphasetwoproject.activities.MainActivity
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Test
    fun mainActivityLaunchesSuccessfully() {
        ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun clickSubmitButton() {
        ActivityScenario.launch(MainActivity::class.java)

        withRobot(MainActivityScreenRobot::class.java)
            .checkIsDisplayed(R.id.action_bar_submit)
            .checkIsDisplayed(R.id.toolbar_title)
            .checkIsDisplayed(R.id.tabLayout)
            .clickSubmitButton()
    }

}