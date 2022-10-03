package com.cometj.yourssu_assignment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.cometj.yourssu_assignment.databinding.FragmentRegister1Binding

class RegisterFragment1 : Fragment(R.layout.fragment_register1) {

    private var _binding: FragmentRegister1Binding? = null
    private val binding get() = _binding!!

    private val viewModel: RegisterViewModel by viewModels()

    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register1, container, false)

//        val navHostFragment = parentFragmentManager.findFragmentById(R.id.registerFragment1) as NavHostFragment
//        navController = navHostFragment.navController


        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment1_to_registerFragment2)
        }

        binding.btnNext.setOnClickListener {

        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}