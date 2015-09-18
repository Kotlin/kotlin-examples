package com.example.dagger.kotlin

import android.location.LocationManager
import javax.inject.Inject

public class DemoApplication : BaseApplication() {

    private var component: ApplicationComponent? = null

    var locationManager: LocationManager? = null // for some reason.
        @Inject set

    override fun onCreate() {
        super.onCreate()
        component = initDaggerComponent()
        component().inject(this) // As of now, LocationManager should be injected into this.
    }

    public fun component(): ApplicationComponent {
        return component!!
    }

}