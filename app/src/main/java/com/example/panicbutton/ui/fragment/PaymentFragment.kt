package com.example.panicbutton.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.viewpager2.widget.ViewPager2
import com.example.panicbutton.R
import com.example.panicbutton.adapter.PaymentPageAdapter
import com.example.panicbutton.databinding.FragmentHomeBinding
import com.example.panicbutton.databinding.FragmentPaymentBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class PaymentFragment : Fragment() {
    // Binding
    private var _binding: FragmentPaymentBinding? = null
    private val binding get() = _binding!!

    // tab layout
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager2: ViewPager2

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.tagihan,
            R.string.riwayat_pembayaran
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentPaymentBinding.inflate(inflater, container, false)
        val view = binding.root

        viewPager2 = binding.viewPager2
        val paymentPageAdapter = PaymentPageAdapter(childFragmentManager, lifecycle)
        viewPager2.adapter = paymentPageAdapter
        viewPager2.isSaveEnabled = false

        tabLayout = binding.tabLayout
        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()

        return view
    }
}