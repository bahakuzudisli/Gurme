package com.kuzudisli.data.di

import android.util.Config.DEBUG
import com.kuzudisli.data.remote.GurmeApi
import com.kuzudisli.data.remote.datasource.user.UserDataSource
import com.kuzudisli.data.remote.datasource.user.UserDataSourceImpl
import com.kuzudisli.data.remote.repository.UserRepositoryImpl
import com.kuzudisli.domain.repos.UserRepository
import com.kuzudisli.domain.usecase.LoginUseCase
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


val connectTimeout: Long = 40// 20s
val readTimeout: Long = 40 // 20s
val BASE_URL = "http://10.0.2.2:8080"

fun provideHttpClient(): OkHttpClient {
    val okHttpClientBuilder = OkHttpClient.Builder()
        .connectTimeout(connectTimeout, TimeUnit.SECONDS)
        .readTimeout(readTimeout, TimeUnit.SECONDS)
    if (DEBUG) {
        val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        okHttpClientBuilder.addInterceptor(httpLoggingInterceptor)
    }
    okHttpClientBuilder.build()
    return okHttpClientBuilder.build()
}

fun provideRetrofit(client: OkHttpClient, baseUrl: String): Retrofit {
    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(client)
        .build()
}

fun provideGurmeApi(retrofit: Retrofit): GurmeApi {
    return retrofit.create(GurmeApi::class.java)
}

val networkModule = module {
    factory { provideHttpClient() }
    factory { provideGurmeApi(provideRetrofit(get(), BASE_URL)) }
}
