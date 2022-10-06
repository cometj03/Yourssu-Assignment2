package com.cometj.yourssu_assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.cometj.yourssu_assignment.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    private val viewModel: RegisterViewModel by viewModels()

    private val fragmentIds: List<Int> = listOf(
        R.id.registerFragment1,
        R.id.registerFragment2,
        R.id.registerFragment3
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        binding.viewModel = viewModel

        binding.btnTitleCancel.setOnClickListener {
            viewModel.goToFirstPage()
        }

        viewModel.currentPosition.observe(this) {
            findNavController(R.id.nav_host_fragment).navigate(fragmentIds[it])
        }
    }
}