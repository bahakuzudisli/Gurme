package com.kuzudisli.data.remote.datasource.user

import android.util.Log
import com.kuzudisli.data.remote.GurmeApi
import com.kuzudisli.data.remote.LoginRequest
import com.kuzudisli.data.remote.SignUpRequest
import com.kuzudisli.domain.model.LoginResult
import com.kuzudisli.domain.model.SignUpResult

class UserDataSourceImpl(private val gurmeApi: GurmeApi): UserDataSource {
    override suspend fun login(email: String, password: String): LoginResult {
        try {
            val response = gurmeApi.login(LoginRequest(email, password))
            if (response.isSuccessful && response.body() != null) {
                return LoginResult.Success(response.body()!!)
            } else {
                Log.d("Spring", "Login Failed: ${response}")
                return LoginResult.Failure("Login Failed: ${response.message()}")
            }
        } catch (e: Exception) {
            Log.d("Spring", "Network error: ${e.message}")
            return LoginResult.Failure("Network Error: ${e.message}")
        }
    }

    override suspend fun signUp(name: String, lastName: String, email: String, password: String): SignUpResult {
        try {
            val response = gurmeApi.signUp(SignUpRequest(name, lastName, email, password))
            if (response.isSuccessful && response.body() != null) {
                return SignUpResult.Success(response.body()!!)
            } else {
                return SignUpResult.Failure("Sign Up Failed: ${response.message()}")
            }
        } catch (e: Exception) {
            return SignUpResult.Failure("Network Error: ${e.message}")
        }
    }
}