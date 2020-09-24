package com.gadsphasetwo.activities

import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.gadsphasetwoproject.activities.SplashScreenActivity
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SplashScreenActivityTest {

    @Test
    fun appLaunchesSuccessfully() {
        ActivityScenario.launch(SplashScreenActivity::class.java)
    }
}