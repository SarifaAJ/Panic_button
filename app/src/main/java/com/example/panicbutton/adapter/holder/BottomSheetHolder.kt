package com.example.panicbutton.adapter.holder

import androidx.recyclerview.widget.RecyclerView
import com.example.panicbutton.databinding.TvBottomDialogBinding
import com.example.panicbutton.model.BottomSheetData

class BottomSheetHolder(var item : TvBottomDialogBinding) : RecyclerView.ViewHolder(item.root) {
    fun setData(data: BottomSheetData) {
        item.name.text = data.name
    }
}