package com.example.butterknife.unbinder

import android.support.annotation.ColorInt
import android.view.View

import butterknife.BindColor
import butterknife.ButterKnife

open class B(view: View) : A(view) {
    @JvmField @BindColor(android.R.color.white) @ColorInt
    internal var whiteColor: Int = 0

    init {
        ButterKnife.bind(this, view)
    }
}
