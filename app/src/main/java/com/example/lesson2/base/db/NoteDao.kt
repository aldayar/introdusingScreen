package com.example.lesson2.base.db

import androidx.core.location.LocationRequestCompat.Quality
import androidx.room.*
import com.example.lesson2.data.model.NoteModel
@Dao
interface NoteDao {

    @Query("select * from notemodel")

    fun getAllNote(): List<NoteModel>

    @Insert
    fun addNote(model:NoteModel)

    @Update
    fun updateNote(model: NoteModel)

    @Delete
    fun deleteNote(model:NoteModel)
}