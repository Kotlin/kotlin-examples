package com.example.butterknife.unbinder

import android.support.annotation.ColorInt
import android.view.View

import butterknife.BindView
import butterknife.BindColor
import butterknife.ButterKnife

open class C(view: View) : B(view) {
    @JvmField @BindColor(android.R.color.transparent) @ColorInt
    internal var transparentColor: Int = 0

    @BindView(android.R.id.button1)
    lateinit var button1: View

    init {
        ButterKnife.bind(this, view)
    }
}
