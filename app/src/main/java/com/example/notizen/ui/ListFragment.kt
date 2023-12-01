package com.example.notizen.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.example.notizen.MainActivity
import com.example.notizen.R
import com.example.notizen.adapter.ItemAdapter
import com.example.notizen.data.Notes
import com.example.notizen.databinding.FragmentListBinding
import com.example.notizen.databinding.ListItemBinding


class ListFragment : Fragment() {
    private lateinit var binding: FragmentListBinding
    private lateinit var adapter: ItemAdapter
    private lateinit var mainActivity: MainActivity



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mainActivity = activity as MainActivity
        val dataset = mainActivity.dataset
        val adapter = ItemAdapter(dataset)
        binding.noteRV.adapter = adapter

        binding.addBTN.setOnClickListener {
            addNote()

        }



    }
    fun addNote() {

        val addNote = AlertDialog.Builder(requireContext())

        //Layout bestimmen
        addNote.setTitle("Note hinzufügen")
        val noteName = EditText(requireContext())
        val noteText = EditText(requireContext())
        addNote.setView(noteText)
        addNote.setView(noteName)

        //Aktionen bestimmen
        addNote.setPositiveButton("Hinzufügen") { dialogInterface, _ ->

            //Ein neues Team hinzufügen
            val name = noteName.text.toString()
            val myNotes: Notes = Notes("bal","bla")

            //In den Daten aktualisiert
            mainActivity.addNotes(myNotes)

            //Daten neu laden und Adapter informieren
            adapter.newData(mainActivity.dataset)

            //Scroll an den Anfang
            binding.noteRV.scrollToPosition(0)


        }

        addNote.setNegativeButton("Abbrechen") { dialogInterface, _ ->
            dialogInterface.cancel()
        }

        addNote.show()
    }




}