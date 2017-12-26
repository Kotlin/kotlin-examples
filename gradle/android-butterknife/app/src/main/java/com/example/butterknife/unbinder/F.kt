package com.example.butterknife.unbinder

import android.support.annotation.ColorInt
import android.view.View

import butterknife.BindColor
import butterknife.ButterKnife

class F(view: View) : D(view) {
    @JvmField @BindColor(android.R.color.background_light) @ColorInt
    internal var backgroundLightColor: Int = 0

    init {
        ButterKnife.bind(this, view)
    }
}
