package com.example.lesson2.base.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.lesson2.data.model.NoteModel

@Database(entities = [NoteModel::class], version = 1)
abstract class NoteDataBase : RoomDatabase() {
    abstract fun getNoteDao(): NoteDao

    companion object{
        private var INSTANCE: NoteDataBase?=null
        private val LOCK = Any()

        private fun buildDataBase(context: Context)=
         Room.databaseBuilder(context,NoteDataBase::class.java,"DB_name").allowMainThreadQueries().build()

        operator fun invoke(context: Context)= INSTANCE?: synchronized(LOCK){
            INSTANCE ?: buildDataBase(context).also { INSTANCE = it }
        }

    }



}