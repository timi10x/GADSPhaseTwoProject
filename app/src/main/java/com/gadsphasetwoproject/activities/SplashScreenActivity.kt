package com.gadsphasetwoproject.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gadsphasetwoproject.R
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext


class SplashScreenActivity : AppCompatActivity(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + Job()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        launch {
            delay(2000L)

            startActivity(Intent(this@SplashScreenActivity, MainActivity::class.java))
            finish()
        }
    }

    override fun onPause() {
        coroutineContext.cancel()
        super.onPause()
    }


}