package com.expansetech.gadsphasetwoproject.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.expansetech.gadsphasetwoproject.R

class SplashScreenActivity : AppCompatActivity() {
    //splash screen timeout
    private val timeout = 2000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, timeout)
    }
}