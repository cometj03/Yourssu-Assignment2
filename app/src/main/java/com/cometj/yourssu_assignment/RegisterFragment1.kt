package com.cometj.yourssu_assignment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.cometj.yourssu_assignment.databinding.FragmentRegister1Binding

class RegisterFragment1 : Fragment(R.layout.fragment_register1) {

    private var _binding: FragmentRegister1Binding? = null
    private val binding get() = _binding!!

    private val viewModel: RegisterViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegister1Binding.inflate(inflater, container, false)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.btnNext.setOnClickListener {
            viewModel.goToNextPage()
            findNavController().navigate(R.id.action_registerFragment1_to_registerFragment2)
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}