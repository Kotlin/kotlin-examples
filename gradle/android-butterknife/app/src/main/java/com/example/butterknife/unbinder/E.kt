package com.example.butterknife.unbinder

import android.support.annotation.ColorInt
import android.view.View

import butterknife.BindColor
import butterknife.ButterKnife

open class E(view: View) : C(view) {
    @JvmField @BindColor(android.R.color.background_dark) @ColorInt
    internal var backgroundDarkColor: Int = 0

    init {
        ButterKnife.bind(this, view)
    }
}
