package com.example.panicbutton.adapter.holder

import androidx.recyclerview.widget.RecyclerView
import com.example.panicbutton.databinding.ItemListInfoBinding
import com.example.panicbutton.model.InformasiData

class InformasiHolder(var item : ItemListInfoBinding) : RecyclerView.ViewHolder(item.root) {
    fun setData(data: InformasiData) {
        item.title.text = data.title
        item.desc.text = data.desc
        item.image.setImageResource(data.image)
    }
}