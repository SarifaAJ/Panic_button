package com.example.panicbutton.ui.homefragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.panicbutton.R
import com.example.panicbutton.databinding.ActivityTambahPanic2Binding

class TambahPanic2Activity : AppCompatActivity() {
    // binding
    private lateinit var binding: ActivityTambahPanic2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTambahPanic2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // back button
        binding.btnBack.setOnClickListener {
            finish()
        }

        // back button
        binding.btnKonfirmasi.setOnClickListener {
            finish()
        }
    }
}