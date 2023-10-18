package com.example.panicbutton.ui.homefragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.panicbutton.R
import com.example.panicbutton.databinding.ActivityDetailPanicBinding

class DetailPanicActivity : AppCompatActivity() {
    // binding
    private lateinit var binding: ActivityDetailPanicBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailPanicBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // back button
        binding.btnBack.setOnClickListener {
            finish()
        }

        // help button
        binding.btnBantuan.setOnClickListener {
            finish()
        }

        val panicName = intent.getStringExtra("title_panic")
        binding.panicName.text = panicName

        val panicStatus = intent.getStringExtra("status_panic")
        binding.status.text = panicStatus
        if (panicStatus == "Online") {
            binding.statusCircle.setImageResource(R.drawable.icon_circle_green)
        } else if (panicStatus == "Offline") {
            binding.statusCircle.setImageResource(R.drawable.icon_circle_dgrey)
        } else if (panicStatus == "Maintenance") {
            binding.statusCircle.setImageResource(R.drawable.icon_circle_yellow)
        } else if (panicStatus == "Menunggu Pemasangan") {
            binding.statusCircle.setImageResource(R.drawable.icon_circle_lgrey)
            binding.timeImg.visibility = View.GONE
            binding.terakhirDiperbarui.visibility = View.GONE
            binding.time.visibility = View.GONE
        }

        val panicTime = intent.getStringExtra("time_panic")
        binding.time.text = panicTime
    }
}