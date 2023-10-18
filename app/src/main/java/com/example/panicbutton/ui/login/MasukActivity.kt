package com.example.panicbutton.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.panicbutton.R
import com.example.panicbutton.databinding.ActivityMasukBinding

class MasukActivity : AppCompatActivity() {
    // binding
    private lateinit var binding: ActivityMasukBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMasukBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // to OTPActivity
        binding.btnMasuk.setOnClickListener {
            val intent = Intent(this@MasukActivity, LoginOTPActivity::class.java)
            startActivity(intent)
        }

        // to MainActivity
        binding.btnDaftar.setOnClickListener {
            val intent = Intent(this@MasukActivity, MainActivity::class.java)
            startActivity(intent)
        }

    }
}