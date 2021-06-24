package com.priyanshumaurya8868.flickrgalleryapp

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.load(uri: String) {
    Glide.with(this).load(uri).circleCrop().into(this)
}
