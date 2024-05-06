package com.kuzudisli.gurme.di

import androidx.work.WorkManager
import com.kuzudisli.data.di.dataModule
import com.kuzudisli.data.di.networkModule
import com.kuzudisli.data.workers.user.LoginWorker
import com.kuzudisli.data.workers.user.SignUpWorker
import com.kuzudisli.domain.usecase.user.LoginUseCase
import com.kuzudisli.domain.usecase.user.SignUpUseCase
import com.kuzudisli.gurme.ui.auth.login.LoginViewModel
import com.kuzudisli.gurme.ui.auth.signup.SignUpViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.workmanager.dsl.worker
import org.koin.androidx.workmanager.dsl.workerOf
import org.koin.core.module.dsl.named
import org.koin.dsl.module


val appModule = module {
    factory { LoginUseCase(get()) }
    viewModel() { LoginViewModel(get()) }
    factory { SignUpUseCase(get()) }
    viewModel() { SignUpViewModel(get()) }
}

val workerModule = module {
    single { WorkManager.getInstance(androidContext()) }
    /*
    single<WorkerFactory> { KoinWorkerFactory() }
    single {
        if (!WorkManager.isInitialized()) {
            val configuration = Configuration.Builder()
                .setWorkerFactory(get<WorkerFactory>())
                .build()
            WorkManager.initialize(androidContext(), configuration)
        }
        WorkManager.getInstance(androidContext())
    }
    */
    workerOf(::LoginWorker) { named<LoginWorker>() }
    workerOf(::SignUpWorker) { named<SignUpWorker>() }
}


val myModule = module {
    // add new module here
    includes(appModule, networkModule, dataModule, workerModule)
}
