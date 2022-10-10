package com.cometj.yourssu_assignment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.yourssu.design.undercarriage.base.TextField
import java.util.regex.Pattern

class RegisterViewModel : ViewModel() {

    private val _currentPosition = MutableLiveData(0)
    val currentPosition: LiveData<Int> = Transformations.distinctUntilChanged(_currentPosition)

    fun goToNextPage() {
        _currentPosition.value = _currentPosition.value?.let { it + 1 }
    }
    fun goToPreviousPage() {
        _currentPosition.value = _currentPosition.value?.let { it - 1 }
    }
    fun goToFirstPage() {
        _currentPosition.value = 0
        _email.value = ""
        _password.value = ""
    }

    private val _email = MutableLiveData("")
    val email: LiveData<String> = _email

    private val _password = MutableLiveData("")
    val password: LiveData<String> = _password

    private val _isPasswordValid = MutableLiveData(false)
    val isPasswordValid: LiveData<Boolean> = _isPasswordValid

    val onEmailTextChangeListener = object : TextField.OnTextChanged {
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            s?.toString()?.let { _email.value = it }
        }
    }

    fun validatePassword(password: String) {
        val regex = "^(?=.*[A-Za-z])(?=.*\\d)[!-~₩]{8,100}$"
        _password.value = password
        _isPasswordValid.value = Pattern.matches(regex, password)
    }
}