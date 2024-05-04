package com.kuzudisli.domain.repos

import com.kuzudisli.domain.model.LoginResult
import com.kuzudisli.domain.model.SignUpResult

interface UserRepository {
    suspend fun login(email: String, password: String): LoginResult
    suspend fun signUp(name: String, lastName: String, email: String, password: String): SignUpResult
}
