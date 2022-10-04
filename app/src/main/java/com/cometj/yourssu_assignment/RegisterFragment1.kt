package com.cometj.yourssu_assignment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import com.cometj.yourssu_assignment.databinding.FragmentRegister1Binding

class RegisterFragment1 : Fragment(R.layout.fragment_register1) {

    private var _binding: FragmentRegister1Binding? = null
    private val binding get() = _binding!!

    private val viewModel: RegisterViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegister1Binding.inflate(inflater, container, false)

        binding.btnNext.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(R.id.action_registerFragment1_to_registerFragment2)
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}