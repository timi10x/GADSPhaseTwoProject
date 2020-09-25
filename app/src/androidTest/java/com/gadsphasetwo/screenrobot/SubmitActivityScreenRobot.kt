package com.gadsphasetwo.screenrobot

import com.gadsphasetwoproject.R

class SubmitActivityScreenRobot : ScreenRobot<SubmitActivityScreenRobot>() {
    fun testSubmitButton(): SubmitActivityScreenRobot? {
        return clickOkOnView(R.id.btn_save_account)
    }

    fun checkFirstName(input: String): SubmitActivityScreenRobot {
        return enterTextIntoView(R.id.edtxt_first_name, input)

    }

    fun checkLastName(input: String): SubmitActivityScreenRobot {
        return enterTextIntoView(R.id.edtxt_last_name, input)
    }

    fun checkEmail(input: String): SubmitActivityScreenRobot {
        return enterTextIntoView(R.id.edtxt_email, input)
    }

    fun checkGithubLink(input: String): SubmitActivityScreenRobot {
        return enterTextIntoView(R.id.edtxt_github_link, input)
    }
}