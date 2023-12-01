package com.example.notizen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.notizen.data.Notes
import com.example.notizen.databinding.ListItemBinding
import com.example.notizen.ui.ListFragment
import com.example.notizen.ui.ListFragmentDirections

class ItemAdapter(
    private var dataset : List<Notes>
): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }



    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val note = dataset[position]

        holder.binding.noteNameTV.text = note.noteName
        holder.binding.noteTextTV.text = note.noteTxt

        holder.binding.noteCardMCV.setOnClickListener {
            val navController = holder.binding.root.findNavController()
            navController.navigate(ListFragmentDirections.actionListFragmentToDetailFragment(position))


        }

        holder.binding.radioButton.setOnClickListener {


        }
    }




    override fun getItemCount(): Int {
        return dataset.size
    }
    fun newData(data: List<Notes>)
    {
        dataset = data
        notifyDataSetChanged()
    }



}