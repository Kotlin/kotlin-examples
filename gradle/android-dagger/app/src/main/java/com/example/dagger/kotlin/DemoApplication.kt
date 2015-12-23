package com.example.dagger.kotlin

public class DemoApplication : BaseApplication() {
    lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        val component = initDaggerComponent()
        component.inject(this) // As of now, LocationManager should be injected into this.
        this.component = component
    }

}