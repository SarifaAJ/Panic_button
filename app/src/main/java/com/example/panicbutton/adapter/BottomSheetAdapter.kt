package com.example.panicbutton.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.panicbutton.adapter.holder.BottomSheetHolder
import com.example.panicbutton.databinding.TvBottomDialogBinding
import com.example.panicbutton.model.BottomSheetData

class BottomSheetAdapter(var daerah: ArrayList<BottomSheetData> = ArrayList(),
                         private val itemClickListener: (String) -> Unit) : RecyclerView.Adapter<BottomSheetHolder>() {
    private var filteredList: ArrayList<BottomSheetData> = ArrayList()

    init {
        filteredList.addAll(daerah)
    }

    fun filter(query: String) {
        filteredList.clear()
        if (query.isEmpty()) {
            filteredList.addAll(daerah)
        } else {
            val searchResults = daerah.filter { it.name.contains(query, true) }
            filteredList.addAll(searchResults)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BottomSheetHolder {
        val binding = TvBottomDialogBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false)
        return BottomSheetHolder(binding)
    }

    override fun getItemCount(): Int {
        return daerah.size
    }

    override fun onBindViewHolder(holder: BottomSheetHolder, position: Int) {
        val data = filteredList[position]
        holder.setData(data)
        holder.itemView.setOnClickListener {
            itemClickListener(data.name)
        }
    }
}