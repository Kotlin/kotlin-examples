package com.sample.icepick.lib

import android.content.Context
import android.os.Parcelable
import android.util.AttributeSet
import android.widget.TextView
import icepick.Icepick
import icepick.State

open class BaseCustomView : TextView {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle)

    @State @JvmField
    var backgroundColor: Int? = null

    fun setBackgroundColorWithAnotherMethod(color: Int) {
        this.backgroundColor = color
        setBackgroundColor(color)
    }

    override fun onSaveInstanceState(): Parcelable {
        return Icepick.saveInstanceState(this, super.onSaveInstanceState())
    }

    override fun onRestoreInstanceState(state: Parcelable) {
        super.onRestoreInstanceState(Icepick.restoreInstanceState(this, state))
        if (backgroundColor != null) {
            setBackgroundColorWithAnotherMethod(backgroundColor!!)
        }
    }
}
