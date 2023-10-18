package com.example.panicbutton.ui.homefragment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.panicbutton.R
import com.example.panicbutton.adapter.InformasiAdapter
import com.example.panicbutton.databinding.ActivityInformasiBinding
import com.example.panicbutton.model.InformasiData

class InformasiActivity : AppCompatActivity() {
    //binding
    private lateinit var binding: ActivityInformasiBinding

    // list info
    private lateinit var infoList : RecyclerView
    private val list = ArrayList<InformasiData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInformasiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // back button
        binding.btnBack.setOnClickListener {
            finish()
        }

        infoList = binding.rvInformasi
        infoList.setHasFixedSize(true)
        list.addAll(getListInformasi())
        showRecyclerList()
    }

    private fun getListInformasi(): Collection<InformasiData> {
        val infoTitle = resources.getStringArray(R.array.info_title)
        val infoDesc = resources.getString(R.string.info_desc)
        val infoImage = resources.obtainTypedArray(R.array.info_picture)
        val listInfo = ArrayList<InformasiData>()

        for (i in infoTitle.indices) {
            val info = InformasiData(infoTitle[i], infoDesc, infoImage.getResourceId(i, 0))
            listInfo.add(info)
        }
        return listInfo
    }

    private fun showRecyclerList() {
        infoList.layoutManager = LinearLayoutManager(this)
        val listInformasiAdapter = InformasiAdapter(list)
        infoList.adapter = listInformasiAdapter

        listInformasiAdapter.setOnItemClickCallback(object  : InformasiAdapter.OnItemClickCallback {
            override fun onItemClicked(data: InformasiData) {
                showSelectedInfo(data)
            }

        })
    }

    private fun showSelectedInfo(info: InformasiData) {
        val position = list.indexOf(info)
        val intent = Intent(this, DetailInformasiActivity::class.java)
        intent.putExtra("position", position)
        startActivity(intent)
    }

}