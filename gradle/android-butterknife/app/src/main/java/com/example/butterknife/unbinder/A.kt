package com.example.butterknife.unbinder

import android.support.annotation.ColorInt
import android.view.View

import butterknife.BindColor
import butterknife.ButterKnife

open class A(view: View) {
    @JvmField @BindColor(android.R.color.black) @ColorInt
    internal var blackColor: Int = 0

    init {
        ButterKnife.bind(this, view)
    }
}
