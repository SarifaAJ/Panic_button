package com.example.panicbutton.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.panicbutton.ui.paymentfragment.RiwayatFragment
import com.example.panicbutton.ui.paymentfragment.TagihanFragment

class PaymentPageAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = TagihanFragment()
            1 -> fragment = RiwayatFragment()
        }
        return fragment as Fragment
    }
}