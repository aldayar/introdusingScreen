package com.example.lesson2.ui.utils

import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImageWithGlide(url : Uri){
    Glide.with(this).load(url).centerCrop().into(this)
}