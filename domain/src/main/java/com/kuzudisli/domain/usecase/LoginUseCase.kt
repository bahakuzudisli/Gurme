package com.kuzudisli.domain.usecase

import com.kuzudisli.domain.model.LoginResult
import com.kuzudisli.domain.repos.UserRepository

class LoginUseCase(private val userRepository: UserRepository) : UseCase<LoginParams, LoginResult> {
    override suspend fun invoke(params: LoginParams): LoginResult {
        return userRepository.login(params.email, params.password)
    }
}

data class LoginParams(val email: String, val password: String)