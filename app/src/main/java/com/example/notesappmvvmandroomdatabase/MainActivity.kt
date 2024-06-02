package com.example.notesappmvvmandroomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.notesappmvvmandroomdatabase.database.NoteDatabase
import com.example.notesappmvvmandroomdatabase.model.NoteViewModel
import com.example.notesappmvvmandroomdatabase.model.NoteViewModelFactory
import com.example.notesappmvvmandroomdatabase.repository.NoteRepository

class MainActivity : AppCompatActivity() {

    lateinit var noteViewModel: NoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewModel()
    }

    private fun setupViewModel(){
        val noteRepository = NoteRepository(NoteDatabase(this))
        val viewModelProviderFactory = NoteViewModelFactory(application,noteRepository)
        noteViewModel = ViewModelProvider(this, viewModelProviderFactory)[NoteViewModel::class.java]
    }
}