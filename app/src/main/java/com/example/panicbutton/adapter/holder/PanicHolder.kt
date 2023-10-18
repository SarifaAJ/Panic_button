package com.example.panicbutton.adapter.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.panicbutton.R
import com.example.panicbutton.databinding.ItemGridPanicBinding
import com.example.panicbutton.databinding.ItemListPanicBinding
import com.example.panicbutton.model.PanicData

interface PanicHolderInterface {
    fun bindData(data: PanicData)
}

// holder for list view
class PanicListHolder(itemView: View) : RecyclerView.ViewHolder(itemView), PanicHolderInterface {
    private val binding = ItemListPanicBinding.bind(itemView)

    override fun bindData(data: PanicData) {
        with(binding) {
            // title
            title.text = data.title
            // status
            status.text = data.status
            //status circle
            if (data.status == "Online") {
                statusCircle.setImageResource(R.drawable.icon_circle_green)
            } else if (data.status == "Offline") {
                statusCircle.setImageResource(R.drawable.icon_circle_dgrey)
            }  else if (data.status == "Maintenance") {
                statusCircle.setImageResource(R.drawable.icon_circle_yellow)
            }else if (data.status == "Menunggu Pemasangan") {
                statusCircle.setImageResource(R.drawable.icon_circle_lgrey)
            }
            // time
            time.text = data.time
            if (data.status == "Menunggu Pemasangan") {
                timeLayout.visibility = View.INVISIBLE
            } else {
                timeLayout.visibility = View.VISIBLE
            }
            // image
            mapImg.setImageResource(data.mapImg)
        }
    }
}

// holder for grid view
class PanicGridHolder(itemView: View) : RecyclerView.ViewHolder(itemView), PanicHolderInterface {
    private val binding = ItemGridPanicBinding.bind(itemView)

    override fun bindData(data: PanicData) {
        with(binding) {
            // title
            title.text = data.title
            // status
            status.text = data.status
            //status circle
            if (data.status == "Online") {
                statusCircle.setImageResource(R.drawable.icon_circle_green)
            } else if (data.status == "Offline") {
                statusCircle.setImageResource(R.drawable.icon_circle_dgrey)
            }  else if (data.status == "Maintenance") {
                statusCircle.setImageResource(R.drawable.icon_circle_yellow)
            }else if (data.status == "Menunggu Pemasangan") {
                statusCircle.setImageResource(R.drawable.icon_circle_lgrey)
            }
            // time
            time.text = data.time
            if (data.status == "Menunggu Pemasangan") {
                timeLayout.visibility = View.INVISIBLE
            } else {
                timeLayout.visibility = View.VISIBLE
            }
            // image
            mapImg.setImageResource(data.mapImg)
        }
    }
}