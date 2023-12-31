package com.example.panicbutton.ui.paymentfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.panicbutton.R
import com.example.panicbutton.adapter.RiwayatAdapter
import com.example.panicbutton.adapter.TagihanAdapter
import com.example.panicbutton.databinding.FragmentRiwayatBinding
import com.example.panicbutton.databinding.FragmentTagihanBinding
import com.example.panicbutton.model.RiwayatData
import com.example.panicbutton.model.TagihanData

class RiwayatFragment : Fragment() {
    // binding
    private var _binding: FragmentRiwayatBinding? = null
    private val binding get() = _binding!!

    // list riwayat
    private lateinit var riwayatList: RecyclerView
    private val listRiwayat = ArrayList<RiwayatData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentRiwayatBinding.inflate(inflater, container, false)
        val view = binding.root

        // tagihan list
        riwayatList = binding.rvRiwayat
        riwayatList.setHasFixedSize(true)
        listRiwayat.addAll(getListRiwayat())
        showRecyclerView()

        return view
    }

    private fun getListRiwayat(): Collection<RiwayatData> {
        val tCode = resources.getStringArray(R.array.code2)
        val tRenewal = resources.getStringArray(R.array.renewal)
        val tStatus = resources.getStringArray(R.array.status2)
        val tTime = resources.getStringArray(R.array.time2)
        val tName = resources.getStringArray(R.array.toko_name)
        val tPrice = resources.getStringArray(R.array.toko_price)
        val tTotal = resources.getStringArray(R.array.total_price)
        val listRiwayat = ArrayList<RiwayatData>()

        for (i in tCode.indices) {
            val riwayat = RiwayatData(tCode[i], tRenewal[i], tStatus[i], tTime[i], tName[i], tPrice[i], tTotal[i])
            listRiwayat.add(riwayat)
        }
        return listRiwayat
    }

    private fun showRecyclerView() {
        riwayatList.layoutManager = LinearLayoutManager(requireContext())
        val listRiwayatAdapter = RiwayatAdapter(listRiwayat)
        riwayatList.adapter = listRiwayatAdapter
    }
}