package com.gadsphasetwo.activities

import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.gadsphasetwo.screenrobot.ScreenRobot.Companion.withRobot
import com.gadsphasetwo.screenrobot.SubmitActivityScreenRobot
import com.gadsphasetwoproject.R
import com.gadsphasetwoproject.activities.SubmitProjectActivity
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SubmitActivityTest {
    val firstName = "daniel"
    val lastName = "olatoye"
    val email = "test@gmail.com"
    val githubLink = "www.github.com"

    @Test
    fun submitActivityLaunchSuccessfully() {
        ActivityScenario.launch(SubmitProjectActivity::class.java)
    }

    @Test
    fun testSubmitButton() {
        ActivityScenario.launch(SubmitProjectActivity::class.java)

        withRobot(SubmitActivityScreenRobot::class.java)
            .checkIsDisplayed(R.id.btn_save_account)
            .testSubmitButton()
    }

    @Test
    fun checkFirstName() {
        ActivityScenario.launch(SubmitProjectActivity::class.java)

        withRobot(SubmitActivityScreenRobot::class.java)
            .clickOkOnView(R.id.edtxt_first_name)
            .checkFirstName(firstName)
    }

    @Test
    fun checkLastName() {
        ActivityScenario.launch(SubmitProjectActivity::class.java)

        withRobot(SubmitActivityScreenRobot::class.java)
            .checkLastName(lastName)
    }

    @Test
    fun checkEmail() {
        ActivityScenario.launch(SubmitProjectActivity::class.java)

        withRobot(SubmitActivityScreenRobot::class.java)
            .checkEmail(email)
    }

    @Test
    fun checkGithubLink() {
        ActivityScenario.launch(SubmitProjectActivity::class.java)

        withRobot(SubmitActivityScreenRobot::class.java)
            .checkGithubLink(githubLink)
    }
}