package com.kuzudisli.domain.datasource.remote

import com.kuzudisli.domain.model.LoginResult
import com.kuzudisli.domain.model.SignUpResult

interface UserDataSource {
    suspend fun login(email: String, password: String): LoginResult
    suspend fun signUp(name: String, lastName: String, email: String, password: String): SignUpResult

}