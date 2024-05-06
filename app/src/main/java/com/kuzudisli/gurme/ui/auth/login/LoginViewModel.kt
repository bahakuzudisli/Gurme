package com.kuzudisli.gurme.ui.auth.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.work.WorkInfo
import com.kuzudisli.domain.model.LoginResult
import com.kuzudisli.domain.usecase.user.LoginParams
import com.kuzudisli.domain.usecase.user.LoginUseCase
import kotlinx.coroutines.launch

class LoginViewModel(val loginUseCase: LoginUseCase) : ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: MutableLiveData<Boolean> = _isLoading

    private val _loginResult = MutableLiveData<WorkInfo>()
    val loginResult: LiveData<WorkInfo> = _loginResult

    fun login(email: String, password: String) {
        viewModelScope.launch {
            loginUseCase(LoginParams(email, password)).observeForever { workInfo ->
                _loginResult.value = workInfo
            }
        }
    }
    fun loginUser(email: String, password: String) {
        isLoading.value = true
        viewModelScope.launch {
            try {
                //_loginResult.postValue(loginUseCase(LoginParams(email, password)))
            } catch (e: Exception) {
                //_loginResult.postValue(e.message?.let { LoginResult.Failure(it) })
            } finally {
                isLoading.value = false
            }
        }
    }
}
