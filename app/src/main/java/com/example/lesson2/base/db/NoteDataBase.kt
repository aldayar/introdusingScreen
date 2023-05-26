package com.example.lesson2.base.db

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.lesson2.data.model.NoteModel

@Database(entities = [NoteModel::class], version = 2)
    abstract class NoteDataBase : RoomDatabase() {
    abstract fun getNoteDao(): NoteDao
    companion object{
        private var INSTANCE: NoteDataBase?=null
        private val LOCK = Any()

        private fun buildDataBase(context: Context)=
         Room.databaseBuilder(context,NoteDataBase::class.java,"DB_name").fallbackToDestructiveMigration().allowMainThreadQueries().build()

        operator fun invoke(context: Context)= INSTANCE?: synchronized(LOCK){
            INSTANCE ?: buildDataBase(context).also { INSTANCE = it }
        }
        fun getInstance(context: Context): NoteDataBase {
            return INSTANCE ?: synchronized(this) {
                val database = Room.databaseBuilder(context.applicationContext,
                    NoteDataBase::class.java,
                    "item_database",
                ).fallbackToDestructiveMigration().build()
                INSTANCE = database
                database
            }
        }

    }
}
