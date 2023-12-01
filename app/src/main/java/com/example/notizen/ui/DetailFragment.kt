package com.example.notizen.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.navArgs
import com.example.notizen.MainActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.notizen.R
import com.example.notizen.databinding.FragmentDetailBinding
import com.example.notizen.databinding.FragmentListBinding


class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    val args: DetailFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val position = args.noteIndex
        val mainActivity = activity as MainActivity
        val note = mainActivity.dataset[position]


        binding.titelET.setText(note.noteName)
        binding.textET.setText(note.noteTxt)

        val navController = binding.root.findNavController()



        requireActivity().onBackPressedDispatcher.addCallback(object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                note.noteTxt = binding.textET.text.toString()
                note.noteName = binding.titelET.text.toString()
                findNavController().popBackStack()

            }
        })

//        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
//            notiz.text = binding.etText.text.toString()
//            notiz.titel = binding.etTitel.text.toString()
//
//            findNavController().popBackStack()
//        }


    }


}