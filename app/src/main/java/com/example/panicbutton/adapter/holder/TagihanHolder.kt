package com.example.panicbutton.adapter.holder

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.panicbutton.R
import com.example.panicbutton.databinding.ItemTagihanBinding
import com.example.panicbutton.model.TagihanData

class TagihanHolder(var item: ItemTagihanBinding) : RecyclerView.ViewHolder(item.root) {
    fun setData(data: TagihanData) {
        item.code.text = data.code
        item.renewal.text = data.renewal
        item.tvStatus.text = data.status
        item.time.text = data.time
        item.tokoName.text = data.tokoName
        item.tokoPrice.text = data.tokoPrice
        item.totalPrice.text = data.totalPrice
        item.payBeforeDate.text = data.payBeforeDate
        item.payBeforeHour.text = data.payBeforeHour

        // Atur visibility option_layout
        if (data.status == "Selesai") {
            item.status.setBackgroundColor(ContextCompat.getColor(item.root.context, R.color.green))
        } else if (data.status == "Kadaluwarsa") {
            item.status.setBackgroundColor(ContextCompat.getColor(item.root.context, R.color.red))
        } else if (data.status == "Menunggu") {
            item.status.setBackgroundColor(ContextCompat.getColor(item.root.context, R.color.orange))
        } else if (data.status == "Pending") {
            item.status.setBackgroundColor(ContextCompat.getColor(item.root.context, R.color.yellow))
        }
    }
}