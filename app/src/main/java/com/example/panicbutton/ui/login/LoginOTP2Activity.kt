package com.example.panicbutton.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.panicbutton.R
import com.example.panicbutton.databinding.ActivityLoginOtp2Binding
import com.example.panicbutton.ui.HomeActivity

class LoginOTP2Activity : AppCompatActivity() {
    // binding
    private lateinit var binding: ActivityLoginOtp2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginOtp2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // to OTP2Activity
        binding.btnKirim.setBackgroundResource(R.drawable.btn_gradient)
        binding.btnKirim.setOnClickListener {
            val intent = Intent(this@LoginOTP2Activity, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}