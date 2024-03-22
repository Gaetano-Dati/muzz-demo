package com.garrodroideveloper.muzzexercise

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class MuzzApp : Application() {

    override fun onCreate() {
        super.onCreate()
        // This is because in case of a real release it won't log for security purposes
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}