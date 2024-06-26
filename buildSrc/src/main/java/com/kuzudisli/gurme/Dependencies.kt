package com.kuzudisli.gurme

object Versions {
    const val coreKtx = "1.9.0"
    const val appcompat = "1.6.1"
    const val material = "1.11.0"
    const val constraintLayout = "2.1.4"
    const val navigation = "2.7.7"
    const val junit = "4.13.2"
    const val androidJUnit = "1.1.5"
    const val espresso = "3.5.1"
    const val koin = "3.5.0"
    const val retrofit = "2.9.0"
    const val okhttp = "4.9.1"
    const val coroutines = "1.5.2"
    const val stepView = "1.5.1"
    const val workRuntime = "2.9.0"
    const val realmDB = "1.11.0"
    const val viewModelVersion = "2.7.0"
    const val glide = "4.15.1"
    const val gms = "21.2.0"
}

object Libs {
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val navigationFragmentKtx = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val junit = "junit:junit:${Versions.junit}"
    const val androidJUnit = "androidx.test.ext:junit:${Versions.androidJUnit}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewModelVersion}"
    const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.viewModelVersion}"
    const val koinCore = "io.insert-koin:koin-core:${Versions.koin}"
    const val koinAndroid = "io.insert-koin:koin-android:${Versions.koin}"
    const val koinWorkManagerr = "io.insert-koin:koin-androidx-workmanager:${Versions.koin}"
    const val koinNavigation = "io.insert-koin:koin-androidx-navigation:${Versions.koin}"
    const val koinTest = "io.insert-koin:koin-test:${Versions.koin}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitRxJava = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
    const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"
    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val coroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutinesPlayServices =
        "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:${Versions.coroutines}"
    const val stepView = "com.github.shuhart:stepview:${Versions.stepView}"
    const val workRuntimeKtx = "androidx.work:work-runtime-ktx:${Versions.workRuntime}"
    const val realmDB = "io.realm.kotlin:library-base:${Versions.realmDB}"
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val gms = "com.google.android.gms:play-services-location:${Versions.gms}"

    // Firebase Libraries
    const val firebaseAuth = "com.google.firebase:firebase-auth-ktx:22.3.1"
    const val firebaseFirestore = "com.google.firebase:firebase-firestore-ktx:24.10.3"
    const val firebaseStorage = "com.google.firebase:firebase-storage-ktx:20.3.0"
    const val firebaseMessaging = "com.google.firebase:firebase-messaging-ktx:23.4.1"
}