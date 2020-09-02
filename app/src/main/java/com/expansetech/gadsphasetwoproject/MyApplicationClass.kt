package com.expansetech.gadsphasetwoproject

import android.app.Application
import androidx.databinding.library.BuildConfig
import timber.log.Timber

class MyApplicationClass: Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}