package com.kuzudisli.domain.usecase.user

import androidx.lifecycle.LiveData
import com.kuzudisli.domain.repos.UserRepository
import com.kuzudisli.domain.usecase.UseCase
import androidx.work.WorkInfo

class LoginUseCase(private val userRepository: UserRepository) : UseCase<LoginParams, LiveData<WorkInfo>> {
    override suspend fun invoke(params: LoginParams): LiveData<WorkInfo> {
        return userRepository.login(params.email, params.password)
    }
}

data class LoginParams(val email: String, val password: String)