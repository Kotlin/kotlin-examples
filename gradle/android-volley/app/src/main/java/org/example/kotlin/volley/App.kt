package org.example.kotlin.volley

import android.app.Application


class App : Application() {
    override fun onCreate() {
        super.onCreate()
        VolleyService.initialize(this)
    }
}