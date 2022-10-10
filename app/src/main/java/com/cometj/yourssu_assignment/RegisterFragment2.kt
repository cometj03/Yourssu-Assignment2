package com.cometj.yourssu_assignment

import android.os.Bundle
import android.text.Editable
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.cometj.yourssu_assignment.databinding.FragmentRegister2Binding
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch

class RegisterFragment2 : Fragment(R.layout.fragment_register2) {

    private var _binding: FragmentRegister2Binding? = null
    private val binding get() = _binding!!

    private val viewModel: RegisterViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegister2Binding.inflate(inflater, container, false)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.btnNext.setOnClickListener {
            viewModel.goToNextPage()
        }
        initView()
        return binding.root
    }

    private fun initView() {
        binding.etPassword.text = Editable.Factory.getInstance().newEditable(
            viewModel.password.value
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        passwordDebounceSetting()
    }

    @OptIn(FlowPreview::class)
    private fun passwordDebounceSetting() {
        val pwFlow = binding.etPassword.textChangeToFlow()
        viewLifecycleOwner.lifecycleScope.launch {
            pwFlow.debounce(300).collect {
                viewModel.validatePassword(it.toString())
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}