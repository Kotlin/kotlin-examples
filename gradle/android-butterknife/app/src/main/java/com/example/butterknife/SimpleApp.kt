package com.example.butterknife

import android.app.Application
import butterknife.ButterKnife

class SimpleApp : Application() {
    override fun onCreate() {
        super.onCreate()
        ButterKnife.setDebug(BuildConfig.DEBUG)
    }
}
