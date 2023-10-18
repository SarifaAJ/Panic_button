package com.example.panicbutton.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.panicbutton.adapter.holder.RiwayatHolder
import com.example.panicbutton.databinding.ItemRiwayatBinding
import com.example.panicbutton.model.RiwayatData
import com.example.panicbutton.ui.paymentfragment.PaymentDetailActivity

class RiwayatAdapter(var listRiwayat: ArrayList<RiwayatData> = ArrayList()) : RecyclerView.Adapter<RiwayatHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: RiwayatData)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RiwayatHolder {
        val binding = ItemRiwayatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RiwayatHolder(binding)
    }

    override fun getItemCount(): Int {
        return listRiwayat.size
    }

    override fun onBindViewHolder(holder: RiwayatHolder, position: Int) {
        val riwayat = listRiwayat[position]
        holder.setData(riwayat)
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listRiwayat[holder.adapterPosition]) }

        // Tambahkan event klik pada item
        holder.itemView.setOnClickListener {
            // Buat Intent untuk membuka PemasanganActivity
            val intent = Intent(holder.itemView.context, PaymentDetailActivity::class.java)

            // Tambahkan data yang diperlukan ke Intent (misalnya, ID tagihan)
            intent.putExtra("payment_code", riwayat.code)
            intent.putExtra("toko_name", riwayat.tokoName)
            intent.putExtra("renewal_status", riwayat.renewal)
            intent.putExtra("payment_status", riwayat.status)
            intent.putExtra("toko_price", riwayat.tokoPrice)
            intent.putExtra("total_price", riwayat.totalPrice)

            // Start Activity dengan Intent
            holder.itemView.context.startActivity(intent)
        }
    }

}