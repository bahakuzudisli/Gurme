package com.kuzudisli.domain.usecase.user

import com.kuzudisli.domain.model.SignUpResult
import com.kuzudisli.domain.repos.UserRepository
import com.kuzudisli.domain.usecase.UseCase

class SignUpUseCase(private val userRepository: UserRepository) :
    UseCase<SignUpParams, SignUpResult> {
    override suspend fun invoke(params: SignUpParams): SignUpResult {
        return userRepository.signUp(params.name, params.lastName, params.email, params.password)
    }
}

data class SignUpParams(val name: String, val lastName: String, val email: String, val password: String)
