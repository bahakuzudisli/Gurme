package com.kuzudisli.domain.repos

import androidx.lifecycle.LiveData
import androidx.work.WorkInfo
import com.kuzudisli.domain.model.SignUpResult

interface UserRepository {
    suspend fun login(email: String, password: String): LiveData<WorkInfo>
    suspend fun signUp(
        name: String,
        lastName: String,
        email: String,
        password: String
    ): LiveData<WorkInfo>
}
