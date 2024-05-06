package com.kuzudisli.data.remote.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkInfo
import androidx.work.WorkManager
import androidx.work.workDataOf
import com.kuzudisli.data.workers.user.LoginWorker
import com.kuzudisli.data.workers.user.SignUpWorker
import com.kuzudisli.domain.repos.UserRepository

class UserRepositoryImpl(private val workManager: WorkManager) : UserRepository {
    override suspend fun login(email: String, password: String): LiveData<WorkInfo> {
        val workRequest = OneTimeWorkRequestBuilder<LoginWorker>()
            .setInputData(workDataOf("email" to email, "password" to password))
            .build()
        workManager.enqueue(workRequest)
        return workManager.getWorkInfoByIdLiveData(workRequest.id)
    }

    override suspend fun signUp(name: String, lastName: String, email: String, password: String):  LiveData<WorkInfo> {

        val workRequest = OneTimeWorkRequestBuilder<SignUpWorker>()
            .setInputData(workDataOf("first_name" to name, "last_name" to lastName, "email" to email, "password" to password))
            .build()
        workManager.enqueue(workRequest)
        return workManager.getWorkInfoByIdLiveData(workRequest.id)
    }
}