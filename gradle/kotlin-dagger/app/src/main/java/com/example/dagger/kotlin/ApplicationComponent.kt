package com.example.dagger.kotlin

import com.example.dagger.kotlin.ui.HomeActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(javaClass<AndroidModule>()))
public interface ApplicationComponent {
    public fun inject(application: BaseApplication)
    public fun inject(homeActivity: HomeActivity)
    public fun inject(demoActivity: DemoActivity)
}