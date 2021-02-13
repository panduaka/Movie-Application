package com.example.movieapp.util

import android.app.Activity
import android.widget.ImageView
import androidx.constraintlayout.widget.Placeholder
import com.bumptech.glide.Glide

internal fun Activity.loadImage(url: String, placeholder: Int, imageView: ImageView, animate: Boolean) {
    val glideImage = Glide.with(this).load(url)
        .centerCrop()
        .placeholder(placeholder)
        .into(imageView)
}