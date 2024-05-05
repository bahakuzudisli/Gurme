package com.kuzudisli.gurme.di

import com.kuzudisli.data.di.dataModule
import com.kuzudisli.data.di.networkModule
import com.kuzudisli.domain.usecase.user.LoginUseCase
import com.kuzudisli.gurme.ui.auth.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModule = module {
    factory { LoginUseCase(get()) }
    viewModel() { LoginViewModel(get()) }
}

val myModule = module {
    // add new module here
    includes(appModule, networkModule, dataModule)
}
