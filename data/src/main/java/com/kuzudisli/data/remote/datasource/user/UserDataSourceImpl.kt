package com.kuzudisli.data.remote.datasource.user

import android.util.Log
import com.kuzudisli.data.remote.GurmeApi
import com.kuzudisli.data.remote.LoginRequest
import com.kuzudisli.data.remote.SignUpRequest
import com.kuzudisli.domain.model.LoginResult
import com.kuzudisli.domain.model.SignUpResult
import com.kuzudisli.domain.model.User

class UserDataSourceImpl(private val gurmeApi: GurmeApi) : UserDataSource {
    override suspend fun login(email: String, password: String): LoginResult {
        return try {
            val response = gurmeApi.login(LoginRequest(email, password))
            if (response.isSuccessful && response.body() != null) {
                LoginResult.Success(response.body()!!)
            } else {
                LoginResult.Failure("Login Failed: ${response.message()}")
            }
        } catch (e: Exception) {
            LoginResult.Failure("Network Error: ${e.message}")
        }
    }

    override suspend fun signUp(
        name: String,
        lastName: String,
        email: String,
        password: String
    ): SignUpResult {
        return try {
            val response = gurmeApi.signUp(SignUpRequest(name, lastName, email, password))

            if (response.isSuccessful && response.body() != null) {
                SignUpResult.Success(response.body()!!)
            } else {
                SignUpResult.Failure("Sign Up Failed: ${response.code()}")
            }
        } catch (e: Exception) {
            SignUpResult.Failure("Network Error: ${e.message}")
        }
    }
}