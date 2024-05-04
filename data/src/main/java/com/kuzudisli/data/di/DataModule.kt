package com.kuzudisli.data.di

import com.kuzudisli.data.remote.datasource.user.UserDataSource
import com.kuzudisli.data.remote.datasource.user.UserDataSourceImpl
import com.kuzudisli.data.remote.repository.UserRepositoryImpl
import com.kuzudisli.domain.repos.UserRepository
import org.koin.dsl.module

val dataModule = module {
    factory<UserDataSource> { UserDataSourceImpl(get()) }
    factory<UserRepository> { UserRepositoryImpl(get()) }
}

