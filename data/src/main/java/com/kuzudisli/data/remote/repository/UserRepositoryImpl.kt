package com.kuzudisli.data.remote.repository

import com.kuzudisli.data.remote.datasource.user.UserDataSource
import com.kuzudisli.domain.model.LoginResult
import com.kuzudisli.domain.model.SignUpResult
import com.kuzudisli.domain.repos.UserRepository

class UserRepositoryImpl(private val userDataSource: UserDataSource) : UserRepository {
    override suspend fun login(email: String, password: String): LoginResult {
        return userDataSource.login(email, password)
    }

    override suspend fun signUp(name: String, lastName: String, email: String, password: String): SignUpResult {
        return userDataSource.signUp(name, lastName, email, password)
    }

}