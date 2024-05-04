package com.kuzudisli.gurme

import org.gradle.api.JavaVersion

object ConfigurationData {
    const val applicationId = "com.kuzudisli.gurme"
    const val compileSdk = 34
    const val buildToolsVersion = "30.0.3"
    const val minSdk = 24
    const val targetSdk= 34
    const val versionCode = 1
    const val versionName = "1.0"
    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    val sourceCompatibility = JavaVersion.VERSION_1_8
    val targetCompatibility = JavaVersion.VERSION_1_8
    const val jvmTarget = "1.8"
}