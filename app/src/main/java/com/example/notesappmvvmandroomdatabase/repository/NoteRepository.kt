package com.example.notesappmvvmandroomdatabase.repository

import androidx.room.Query
import com.example.notesappmvvmandroomdatabase.database.NoteDatabase
import com.example.notesappmvvmandroomdatabase.model.Note

class NoteRepository(private val db:NoteDatabase) {
    suspend fun insertNote(note: Note) = db.getNoteDao().insertNote(note)
    suspend fun deleteNote(note: Note) = db.getNoteDao().deleteNote(note)
    suspend fun updateNote(note: Note) = db.getNoteDao().updateNote(note)

    fun getAllNotes() = db.getNoteDao().getAllNotes()
    fun searchNote(query: String?) = db.getNoteDao().searchNote(query)
}