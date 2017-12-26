package com.example.butterknife.unbinder

import android.support.annotation.ColorInt
import android.view.View

import butterknife.BindColor
import butterknife.ButterKnife

open class D(view: View) : C(view) {
    @JvmField @BindColor(android.R.color.darker_gray) @ColorInt
    internal var grayColor: Int = 0

    init {
        ButterKnife.bind(this, view)
    }
}
