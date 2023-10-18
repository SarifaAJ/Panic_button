package com.example.panicbutton.ui.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.panicbutton.R
import com.example.panicbutton.databinding.FragmentHomeBinding
import com.example.panicbutton.databinding.FragmentProfileBinding
import com.example.panicbutton.dialog.LogoutDialog
import com.example.panicbutton.dialog.UpdatePhoneDialog
import com.example.panicbutton.ui.HomeActivity
import com.example.panicbutton.ui.login.MasukActivity
import com.example.panicbutton.ui.profilefragment.EditEmailActivity
import com.example.panicbutton.ui.profilefragment.EditNamaActivity
import com.example.panicbutton.ui.profilefragment.EditSelulerActivity
import com.example.panicbutton.ui.profilefragment.ProfileOTPActivity

class ProfileFragment : Fragment() {
    // Binding
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val view = binding.root

        // to EditNamaActivity
        binding.edtNama.setOnClickListener {
            val intent = Intent(requireContext(), EditNamaActivity::class.java)
            startActivity(intent)
        }

        // to EditSelulerActivity
        binding.edtNoSeluler.setOnClickListener {
            val intent = Intent(requireContext(), EditSelulerActivity::class.java)
            startActivity(intent)
        }

        // to EditEmailActivity
        binding.edtEmail.setOnClickListener {
            val intent = Intent(requireContext(), EditEmailActivity::class.java)
            startActivity(intent)
        }

        // logout
        binding.btnLogout.setOnClickListener {
            // confirmation dialog
            val confirmTitle = getString(R.string.logout_title)
            val confirmText = getString(R.string.logout_desc)

            val logoutDialog = LogoutDialog(requireContext(), confirmTitle, confirmText) {
                Toast.makeText(requireContext(), "Logout successfully", Toast.LENGTH_SHORT).show()
            }
            logoutDialog.show()
        }

        return view
    }
}