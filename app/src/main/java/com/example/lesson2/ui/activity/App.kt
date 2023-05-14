package com.example.lesson2.ui.activity

import android.app.Application
import android.content.SharedPreferences
import com.example.lesson2.base.db.NoteDataBase
import com.example.lesson2.ui.utils.Prefs

class App: Application() {
    private lateinit var preferences: SharedPreferences
    companion object {
        lateinit var prefs: Prefs
        lateinit var db: NoteDataBase
    }
    override fun onCreate() {
        super.onCreate()
        preferences = this.applicationContext.getSharedPreferences("settings", MODE_PRIVATE)
        prefs = Prefs(preferences)

        db = NoteDataBase(this.applicationContext)
    }
}