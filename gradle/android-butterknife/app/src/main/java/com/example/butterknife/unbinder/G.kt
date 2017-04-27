package com.example.butterknife.unbinder

import android.support.annotation.ColorInt
import android.view.View

import butterknife.BindView
import butterknife.BindColor
import butterknife.ButterKnife
import butterknife.OnClick

open class G(view: View) : E(view) {
    @JvmField @BindColor(android.R.color.darker_gray) @ColorInt
    internal var grayColor: Int = 0

    @BindView(android.R.id.button2)
    lateinit var button2: View

    init {
        ButterKnife.bind(this, view)
    }

    @OnClick(android.R.id.content)
    fun onClick() {
        // On click handler
    }
}
