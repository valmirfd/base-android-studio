package com.valorizeseusamigos.projetobase.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.valorizeseusamigos.projetobase.R
import com.valorizeseusamigos.projetobase.databinding.FragmentRecoverAccountBinding
import com.valorizeseusamigos.projetobase.databinding.FragmentRegisterBinding
import com.valorizeseusamigos.projetobase.util.initToolbar
import com.valorizeseusamigos.projetobase.util.showBottomSheet


class RecoverAccountFragment : Fragment() {

    private var _binding: FragmentRecoverAccountBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecoverAccountBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initToolbar(binding.toolbar)

        initListeners()
    }

    private fun initListeners() {
        binding.btnRecover.setOnClickListener { validateData() }
    }

    private fun validateData() {
        val email = binding.edtEmail.text.toString().trim()

        if (email.isNotEmpty()) {
            Toast.makeText(requireContext(), "Tudo Certo.", Toast.LENGTH_SHORT).show()
        } else {
            showBottomSheet(message = getString(R.string.email_empty))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}