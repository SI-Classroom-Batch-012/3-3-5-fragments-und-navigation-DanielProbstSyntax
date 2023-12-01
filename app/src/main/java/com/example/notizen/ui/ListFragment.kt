package com.example.notizen.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.notizen.MainActivity
import com.example.notizen.R
import com.example.notizen.adapter.ItemAdapter
import com.example.notizen.databinding.FragmentListBinding
import com.example.notizen.databinding.ListItemBinding


class ListFragment : Fragment() {
    private lateinit var binding: FragmentListBinding



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



    }




}