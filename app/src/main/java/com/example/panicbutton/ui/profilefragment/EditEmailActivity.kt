package com.example.panicbutton.ui.profilefragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.panicbutton.R
import com.example.panicbutton.databinding.ActivityEditEmailBinding

class EditEmailActivity : AppCompatActivity() {
    // binding
    private lateinit var binding: ActivityEditEmailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditEmailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // back button
        binding.btnBack.setOnClickListener {
            finish()
        }

        // save button
        binding.btnSave.setOnClickListener {
            finish()
        }
    }
}