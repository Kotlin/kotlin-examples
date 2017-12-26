package com.example.butterknife.unbinder

import android.support.annotation.ColorInt
import android.view.View

import butterknife.BindView
import butterknife.BindColor
import butterknife.ButterKnife

class H(view: View) : G(view) {
    @JvmField @BindColor(android.R.color.primary_text_dark) @ColorInt
    internal var primaryTextDark: Int = 0

    @BindView(android.R.id.button3)
    lateinit var button3: View

    init {
        ButterKnife.bind(this, view)
    }
}
