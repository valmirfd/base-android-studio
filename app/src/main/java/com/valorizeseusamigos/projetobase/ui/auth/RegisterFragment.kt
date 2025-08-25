package com.valorizeseusamigos.projetobase.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.valorizeseusamigos.projetobase.R
import com.valorizeseusamigos.projetobase.databinding.FragmentLoginBinding
import com.valorizeseusamigos.projetobase.databinding.FragmentRegisterBinding
import com.valorizeseusamigos.projetobase.util.initToolbar
import com.valorizeseusamigos.projetobase.util.showBottomSheet


class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initToolbar(binding.toolbar)

        initListeners()

    }

    private fun initListeners() {
        binding.btnRegister.setOnClickListener { validateData() }
    }

    private fun validateData() {
        val email = binding.edtEmail.text.toString().trim()
        val password = binding.edtPassword.text.toString().trim()

        if (email.isNotEmpty()) {
            if (password.isNotEmpty()) {

                Toast.makeText(requireContext(), "Tudo Certo.", Toast.LENGTH_SHORT).show()

            } else {
                showBottomSheet(message = getString(R.string.password_empty_register_fragment))
            }
        } else {
            showBottomSheet(message = getString(R.string.email_empty_register_fragment))
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}