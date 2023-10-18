package com.example.panicbutton.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.panicbutton.R
import com.example.panicbutton.databinding.ActivityHomeBinding
import com.example.panicbutton.ui.fragment.HomeFragment
import com.example.panicbutton.ui.fragment.PaymentFragment
import com.example.panicbutton.ui.fragment.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    // binding
    private lateinit var binding: ActivityHomeBinding

    private var selectedTab = 1
    private lateinit var bottomNavView : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        bottomNavView = binding.bottomNav

        // fragment
        val homeFragment = HomeFragment()
        val paymentFragment = PaymentFragment()
        val profileFragment = ProfileFragment()

        // Tambahkan HomeFragment ke dalam container pertama kali saat aktivitas dibuat
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, homeFragment)
            .commit()

        bottomNavView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.nav_home -> {
                    setThatFragment(homeFragment)
                }
                R.id.nav_payment -> {
                    setThatFragment(paymentFragment)
                }
                R.id.nav_profile -> {
                    setThatFragment(profileFragment)
                }
            }
            true
        }

        val fragmentTag = intent.getStringExtra("FRAGMENT_TAG")
        if (fragmentTag == "PROFILE_FRAGMENT") {
            // Ganti tampilan fragment ke ProfileFragment
            val profileFragment = supportFragmentManager.findFragmentByTag("PROFILE_FRAGMENT")
            if (profileFragment is ProfileFragment) {
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.fragment_container, profileFragment)
                transaction.commit()
            }
        }

    }

    private fun setThatFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            commit()
        }
}