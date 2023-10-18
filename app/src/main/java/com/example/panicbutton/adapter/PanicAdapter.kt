package com.example.panicbutton.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.panicbutton.adapter.holder.PanicGridHolder
import com.example.panicbutton.adapter.holder.PanicListHolder
import com.example.panicbutton.databinding.ItemGridPanicBinding
import com.example.panicbutton.databinding.ItemListPanicBinding
import com.example.panicbutton.model.PanicData
import com.example.panicbutton.ui.homefragment.DetailPanicActivity

class PanicAdapter(
    private var initialData: ArrayList<PanicData> = ArrayList(),
    private val viewType: Int
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val data = ArrayList(initialData)

    companion object {
        const val VIEW_TYPE_LIST = 1
        const val VIEW_TYPE_GRID = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_LIST -> {
                val binding = ItemListPanicBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                PanicListHolder(binding.root)
            }
            VIEW_TYPE_GRID -> {
                val binding = ItemGridPanicBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                PanicGridHolder(binding.root)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return viewType
    }

    override fun getItemCount(): Int {
        return initialData.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val dataItem = initialData[position]

        if (holder is PanicListHolder) {
            holder.bindData(dataItem)
        } else if (holder is PanicGridHolder) {
            holder.bindData(dataItem)
        }

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailPanicActivity::class.java)
            intent.putExtra("title_panic", dataItem.title)
            intent.putExtra("status_panic", dataItem.status)
            intent.putExtra("time_panic", dataItem.time)
            holder.itemView.context.startActivity(intent)
        }
    }
}