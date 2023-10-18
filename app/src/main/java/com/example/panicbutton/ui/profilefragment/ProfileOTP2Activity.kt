package com.example.panicbutton.ui.profilefragment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.panicbutton.R
import com.example.panicbutton.databinding.ActivityProfileOtp2Binding
import com.example.panicbutton.ui.HomeActivity
import com.example.panicbutton.ui.fragment.ProfileFragment

class ProfileOTP2Activity : AppCompatActivity() {
    // binding
    private lateinit var binding: ActivityProfileOtp2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileOtp2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // to OTP2Activity
        binding.btnKirim.setBackgroundResource(R.drawable.btn_gradient)
        binding.btnKirim.setOnClickListener {
            val intent = Intent(this@ProfileOTP2Activity, HomeActivity::class.java)
            intent.putExtra("FRAGMENT_TAG", "PROFILE_FRAGMENT")
            startActivity(intent)
        }
    }
}