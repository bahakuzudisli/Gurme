package com.kuzudisli.gurme.ui.auth.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kuzudisli.domain.model.SignUpResult
import com.kuzudisli.domain.usecase.user.SignUpParams
import com.kuzudisli.domain.usecase.user.SignUpUseCase
import kotlinx.coroutines.launch

class SignUpViewModel(private val signUpUseCase: SignUpUseCase) : ViewModel() {
    private val _signUpResult = MutableLiveData<SignUpResult?>()
    val signUpResult: MutableLiveData<SignUpResult?> = _signUpResult

    fun signUp(name: String, lastName: String, email: String, password: String) {
        viewModelScope.launch {
            _signUpResult.value = signUpUseCase(SignUpParams(name, lastName, email, password))
        }
    }
}
