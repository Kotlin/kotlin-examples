package org.example.kotlin.databinding

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide

object ImageBindingAdapter {
    @JvmStatic
    @BindingAdapter("android:src")
    fun setImageUrl(view: ImageView, url: String) {
        Glide.with(view.context).load(url).into(view)
    }
}