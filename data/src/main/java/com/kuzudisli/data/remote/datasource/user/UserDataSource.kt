package com.kuzudisli.data.remote.datasource.user

import com.kuzudisli.domain.model.LoginResult
import com.kuzudisli.domain.model.SignUpResult
import com.kuzudisli.domain.model.User

interface UserDataSource {
    suspend fun login(email: String, password: String): LoginResult
    suspend fun signUp(name: String, lastName: String, email: String, password: String): SignUpResult

}