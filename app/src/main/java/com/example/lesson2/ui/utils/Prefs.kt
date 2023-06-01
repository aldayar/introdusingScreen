package com.example.lesson2.ui.utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.widget.Toast

class Prefs(private val preferences:SharedPreferences) {

    fun saveBoardState() {
        preferences.edit().putBoolean("isShow", true).apply()
    }
    @SuppressLint("CommitPrefEdits")
    fun logOut(context: Context) {
        preferences.edit().clear().apply()
        Toast.makeText(context, "Successfully logged out", Toast.LENGTH_SHORT).show()
    }

    fun isBoardShow(): Boolean {
        return preferences.getBoolean("isShow", false)
    }
    fun saveUserMod(){
        preferences.edit().putBoolean("registered",true).apply ()
    }
    fun isRegisterShowed():Boolean{
        return preferences.getBoolean("registered",false)
    }
    fun saveRegByFireBase(){
        preferences.edit().putBoolean("registeredFB",true).apply ()
    }
    fun isRegByFBShowed():Boolean{
        return preferences.getBoolean("registeredFB",false  )
    }

    @SuppressLint("CommitPrefEdits")
    fun saveUserName(name: String) {
        preferences.edit().putString("name", name).apply()
    }

    fun getUserName(): String {
        return preferences.getString("name", "Name is empty")!!
    }

    fun saveSurUserName(name: String) {
        preferences.edit().putString("sur_user_name", name).apply()
    }

    fun getSurUserName(): String {
        return preferences.getString("sur_user_name", "Sur name is empty")!!
    }

    fun saveUserPhone(number: Int) {
        preferences.edit().putInt("number", number).apply()
    }

    fun getUserNumber(): Int {
        return preferences.getInt("number", 1)
    }

    fun isUserMarried(isMarried: Boolean): Boolean {
        preferences.edit().putBoolean("isMarried", isMarried).apply()
        return isMarried
    }

    fun getUserMarried(): Boolean {
        return preferences.getBoolean("isMarried", false)
    }

}
