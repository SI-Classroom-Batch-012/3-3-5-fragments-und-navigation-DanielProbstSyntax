package com.example.notizen.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.notizen.MainActivity
import com.example.notizen.R
import com.example.notizen.databinding.FragmentDetailBinding
import com.example.notizen.databinding.FragmentListBinding


class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding







    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        val position = args.buchIndex
//        val mainActivity = activity as MainActivity
//        val buch = mainActivity.dataset[position]
//    }


}