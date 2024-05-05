package com.kuzudisli.domain.model

data class User(
    val id: Int,
    val first_name: String,
    val last_name: String,
    val phone_number: String? = null,
    val address: String? = null,
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

