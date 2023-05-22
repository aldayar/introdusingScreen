package com.example.lesson2.ui.utils

import android.annotation.SuppressLint
import android.content.SharedPreferences

class Prefs(private val preferences:SharedPreferences) {

    fun saveBoardState(){
        preferences.edit().putBoolean("isShow",true).apply()
    }
    fun isBoardShow():Boolean{
        return preferences.getBoolean("isShow", false)
    }
    @SuppressLint("CommitPrefEdits")
    fun saveUserName(name:String){
        preferences.edit().putString("name",name).apply()
    }
    fun getUserName(): String{
        return preferences.getString("name","Unknown")!!
    }
    fun saveSurUserName(name:String){
        preferences.edit().putString("name",name).apply()
    }
    fun getSurUserName(): String{
        return preferences.getString("name","Unknown")!!
    }
    fun saveUserPhone(number:Int){
        preferences.edit().putInt("number",number).apply()
    }
    fun getUserNumber(): Int{
        return preferences.getInt("number", 1)
    }
    fun saveUserMArried(isMAried:Boolean){
        preferences.edit().putBoolean("isMeried",isMAried).apply()
    }
    fun getUserMeried(): Boolean{
        return preferences.getBoolean("isMeried", false)
    }

}