package com.kuzudisli.domain.model

data class User(
    val id: Int,
    val name: String,
    val lastName: String,
    val phoneNumber: String,
    val address: String,
    val email: String,
    val password: String
)

sealed class LoginResult {
    data class Success(val user: User) : LoginResult()
    data class Failure(val error: String) : LoginResult()
}

sealed class SignUpResult {
    data class Success(val user: User) : SignUpResult()
    data class Failure(val error: String) : SignUpResult()
}

