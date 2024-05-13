package com.kuzudisli.data.workers.user

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.kuzudisli.domain.datasource.remote.UserDataSource
import com.kuzudisli.domain.model.SignUpResult

class SignUpWorker(
    context: Context,
    workerParams: WorkerParameters,
    private val userDataSource: UserDataSource
) : CoroutineWorker(context, workerParams) {
    override suspend fun doWork(): Result {
        return try {
            Log.d("mytest", "doWork")
            val email = inputData.getString("email")
            val password = inputData.getString("password")
            val name = inputData.getString("first_name")
            val lastName = inputData.getString("last_name")
            val result = userDataSource.signUp(name.toString(),lastName.toString(),email.toString(), password.toString())

            when (result) {
                is SignUpResult.Success -> {
                    Result.success()
                }
                is SignUpResult.Failure -> {
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