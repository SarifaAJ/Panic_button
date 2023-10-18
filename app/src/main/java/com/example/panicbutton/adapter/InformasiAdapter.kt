package com.example.panicbutton.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.panicbutton.adapter.holder.InformasiHolder
import com.example.panicbutton.databinding.ItemListInfoBinding
import com.example.panicbutton.model.InformasiData

class InformasiAdapter(var listInfo: ArrayList<InformasiData> = ArrayList()) : RecyclerView.Adapter<InformasiHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: InformasiData)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InformasiHolder {
        val binding = ItemListInfoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false)
        return InformasiHolder(binding)
    }

    override fun getItemCount(): Int {
        return listInfo.size
    }

    override fun onBindViewHolder(holder: InformasiHolder, position: Int) {
        holder.setData(listInfo[position])
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listInfo[holder.adapterPosition]) }
    }

}