package com.kuzudisli.domain.usecase.user

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.work.WorkInfo
import com.kuzudisli.domain.model.SignUpResult
import com.kuzudisli.domain.repos.UserRepository
import com.kuzudisli.domain.usecase.UseCase

class SignUpUseCase(private val userRepository: UserRepository) :
    UseCase<SignUpParams, LiveData<WorkInfo>> {
    override suspend fun invoke(params: SignUpParams):  LiveData<WorkInfo> {

        return userRepository.signUp(params.name, params.lastName, params.email, params.password)
    }
}

data class SignUpParams(val name: String, val lastName: String, val email: String, val password: String)
