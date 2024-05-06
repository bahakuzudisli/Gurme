package com.kuzudisli.data.workers.user

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.kuzudisli.data.remote.datasource.user.UserDataSource
import com.kuzudisli.domain.model.LoginResult

class LoginWorker(
    context: Context,
    workerParams: WorkerParameters,
    private val userDataSource: UserDataSource
) : CoroutineWorker(context, workerParams) {
    override suspend fun doWork(): Result {
        return try {
            val email = inputData.getString("email")
            val password = inputData.getString("password")
            val result = userDataSource.login(email.toString(), password.toString())
            when (result) {
                is LoginResult.Success -> {
                    Result.success()
                }
                is LoginResult.Failure -> {
                    Result.failure()
                }
                else -> {
                    Result.failure()
                }
            }
        } catch (e: Exception) {
            Result.failure()
        }
    }
}
