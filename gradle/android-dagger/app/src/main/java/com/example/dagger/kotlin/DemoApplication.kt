package com.example.dagger.kotlin

public class DemoApplication : BaseApplication() {

    private lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        component = initDaggerComponent()
        component().inject(this) // As of now, LocationManager should be injected into this.
    }

    public fun component(): ApplicationComponent = component

}