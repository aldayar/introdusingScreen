package com.example.lesson2.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NoteModel(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    var title: String,
    var des: String,
    var date: String)
