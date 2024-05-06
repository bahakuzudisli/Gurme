package com.kuzudisli.gurme.ui.auth.signup

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.work.WorkInfo
import com.kuzudisli.domain.model.SignUpResult
import com.kuzudisli.domain.usecase.user.SignUpParams
import com.kuzudisli.domain.usecase.user.SignUpUseCase
import kotlinx.coroutines.launch

class SignUpViewModel(private val signUpUseCase: SignUpUseCase) : ViewModel() {
    private val _signUpResult = MutableLiveData<WorkInfo?>()
    val signUpResult: LiveData<WorkInfo?> = _signUpResult

    fun signUp(name: String, lastName: String, email: String, password: String) {
        viewModelScope.launch {
            signUpUseCase(SignUpParams(name, lastName, email, password)).observeForever { workInfo ->
                _signUpResult.value = workInfo
            }
        }
    }
}
