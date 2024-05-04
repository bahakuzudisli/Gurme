package com.kuzudisli.domain.usecase

import com.kuzudisli.domain.Resource
import com.kuzudisli.domain.model.User

interface GetUserUseCase {
    suspend operator fun invoke(): Resource<User>
}