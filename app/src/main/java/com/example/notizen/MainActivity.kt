package com.example.notizen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.notizen.data.Datasource
import com.example.notizen.data.Notes
import com.example.notizen.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    var dataset: List<Notes> = listOf()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dataset = Datasource().loadNotes()
    }

    fun addNotes(newNote: Notes){
        dataset = listOf(newNote) + dataset
    }
}