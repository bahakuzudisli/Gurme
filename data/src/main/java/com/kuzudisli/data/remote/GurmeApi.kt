package com.kuzudisli.data.remote

import com.kuzudisli.domain.model.User
import retrofit2.Response

import retrofit2.http.Body
import retrofit2.http.POST

interface GurmeApi {
    @POST("users/signin")
    suspend fun login(@Body credentials: LoginRequest): Response<User>

    @POST("users")
    suspend fun signUp(@Body signUpRequest: SignUpRequest): Response<User>
}

data class LoginRequest(val email: String, val password: String)
data class SignUpRequest(
    val name: String,
    val lastName: String,
    val email: String,
    val password: String
)
