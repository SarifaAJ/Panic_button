package com.example.panicbutton.ui.profilefragment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.panicbutton.R
import com.example.panicbutton.databinding.ActivityEditSelulerBinding
import com.example.panicbutton.dialog.LogoutDialog
import com.example.panicbutton.dialog.UpdatePhoneDialog

class EditSelulerActivity : AppCompatActivity() {
    // binding
    private lateinit var binding: ActivityEditSelulerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditSelulerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // back button
        binding.btnBack.setOnClickListener {
            finish()
        }

        // next button
        binding.btnNext.setOnClickListener {

            // confirmation dialog
            val confirmTitle = getString(R.string.logout_title)
            val confirmText = getString(R.string.logout_desc)

            val updatePhoneDialog = UpdatePhoneDialog(this, confirmTitle, confirmText) {
                val intent = Intent(this, ProfileOTPActivity::class.java)
                startActivity(intent)
            }
            updatePhoneDialog.show()
        }
    }
}