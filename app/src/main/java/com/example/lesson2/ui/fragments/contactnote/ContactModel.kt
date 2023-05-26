package com.example.lesson2.ui.fragments.contactnote

import android.graphics.Bitmap

data class ContactModel (
    val img: Bitmap? =null,
    val name: String,
    val number: String
    )