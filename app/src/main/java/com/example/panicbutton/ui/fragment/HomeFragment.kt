package com.example.panicbutton.ui.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.panicbutton.R
import com.example.panicbutton.adapter.InformasiAdapter
import com.example.panicbutton.adapter.PanicAdapter
import com.example.panicbutton.databinding.FragmentHomeBinding
import com.example.panicbutton.model.InformasiData
import com.example.panicbutton.model.PanicData
import com.example.panicbutton.ui.homefragment.DetailInformasiActivity
import com.example.panicbutton.ui.homefragment.InformasiActivity
import com.example.panicbutton.ui.homefragment.TambahPanicActivity

class HomeFragment : Fragment() {
    // Binding
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    // list info
    private lateinit var infoList : RecyclerView
    private val listInfo = ArrayList<InformasiData>()

    // list panic
    private lateinit var panicAdapter: PanicAdapter
    private var isListView = true
    private lateinit var panicList : RecyclerView
    private val listPanic = ArrayList<PanicData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        // Toggle view between list and grid when btn_list is clicked
        binding.toggleButton.setOnClickListener {
            isListView = !isListView
            toggleRecyclerViewLayout()
        }

        // floating button
        binding.floatingActionButton.setOnClickListener {
            val intent = Intent(requireContext(), TambahPanicActivity::class.java)
            startActivity(intent)
        }
        // to InformasiActivity
        binding.btnLihatSemua.setOnClickListener {
            val intent = Intent(requireContext(), InformasiActivity::class.java)
            startActivity(intent)
        }

        // info list
        infoList = binding.rvInformasi
        infoList.setHasFixedSize(true)
        listInfo.addAll(getListInformasi())
        showRecyclerList()

        // panic list
        panicList = binding.rvPanicButton
        panicList.setHasFixedSize(true)
        listPanic.addAll(getListPanic())
        toggleRecyclerViewLayout()

        return view
    }

    private fun toggleRecyclerViewLayout() {
        if (isListView) {
            panicList.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            binding.toggleButton.setImageResource(R.drawable.icon_list_view)
            panicAdapter = PanicAdapter(initialData = listPanic, viewType = PanicAdapter.VIEW_TYPE_LIST)
        } else {
            panicList.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            binding.toggleButton.setImageResource(R.drawable.icon_grid_view)
            panicAdapter = PanicAdapter(initialData = listPanic, viewType = PanicAdapter.VIEW_TYPE_GRID)
        }

        panicList.adapter = panicAdapter
        panicAdapter.notifyDataSetChanged()
    }

    private fun getListInformasi(): Collection<InformasiData> {
        val infoTitle = resources.getStringArray(R.array.info_title)
        val infoDesc = resources.getString(R.string.info_desc)
        val infoImage = resources.obtainTypedArray(R.array.info_picture)
        val listInfo = ArrayList<InformasiData>()

        // Batasi hanya 5 item pertama
        val itemCount = Math.min(infoTitle.size, 5)

        for (i in 0 until itemCount) {
            val info = InformasiData(infoTitle[i], infoDesc, infoImage.getResourceId(i, 0))
            listInfo.add(info)
        }
        infoImage.recycle()
        return listInfo
    }

    private fun getListPanic() : Collection<PanicData> {
        val panicTitle = resources.getStringArray(R.array.toko_name)
        val panicStatus = resources.getStringArray(R.array.toko_status)
        val panicTime = resources.getStringArray(R.array.toko_time)
        val panicImage = resources.obtainTypedArray(R.array.toko_image)
        val listPanic = ArrayList<PanicData>()

        for (i in panicTitle.indices) {
            val panic = PanicData(panicTitle[i], panicStatus[i], panicTime[i], panicImage.getResourceId(i, 0))
            listPanic.add(panic)
        }
        panicImage.recycle()
        return listPanic
    }

    private fun showRecyclerList() {
        infoList.layoutManager = LinearLayoutManager(requireContext())
        val listInformasiAdapter = InformasiAdapter(listInfo)
        infoList.adapter = listInformasiAdapter

        listInformasiAdapter.setOnItemClickCallback(object  : InformasiAdapter.OnItemClickCallback {
            override fun onItemClicked(data: InformasiData) {
                showSelectedInfo(data)
            }
        })
    }

    private fun showSelectedInfo(info: InformasiData) {
        val position = listInfo.indexOf(info)
        val intent = Intent(requireContext(), DetailInformasiActivity::class.java)
        intent.putExtra("position", position)
        startActivity(intent)
    }
}