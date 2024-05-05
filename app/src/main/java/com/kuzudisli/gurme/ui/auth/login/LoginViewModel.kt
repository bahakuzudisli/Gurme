package com.kuzudisli.gurme.ui.auth.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kuzudisli.domain.model.LoginResult
import com.kuzudisli.domain.usecase.user.LoginParams
import com.kuzudisli.domain.usecase.user.LoginUseCase
import kotlinx.coroutines.launch

class LoginViewModel(val loginUseCase: LoginUseCase) : ViewModel() {
    private val _loginResult = MutableLiveData<LoginResult?>()
    val loginResult: MutableLiveData<LoginResult?> = _loginResult

    fun login(email: String, password: String) {
        viewModelScope.launch {
            _loginResult.value = loginUseCase(LoginParams(email, password))
            if (_loginResult.value is LoginResult.Success) {
                // Save token
                Log.d("spring", "lastName: ${(_loginResult.value as LoginResult.Success).user.last_name}")
            }
        }
    }
}
