package com.kuzudisli.gurme.ui.auth.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kuzudisli.domain.model.LoginResult
import com.kuzudisli.domain.usecase.LoginParams
import com.kuzudisli.domain.usecase.LoginUseCase
import kotlinx.coroutines.launch

class LoginViewModel(val loginUseCase: LoginUseCase) : ViewModel() {
    private val _loginResult = MutableLiveData<LoginResult?>()
    val loginResult: MutableLiveData<LoginResult?> = _loginResult

    fun login(email: String, password: String) {
        viewModelScope.launch {
            _loginResult.value = loginUseCase(LoginParams(email, password))
        }
    }
}
