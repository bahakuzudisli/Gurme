package com.kuzudisli.gurme

import org.gradle.api.JavaVersion

object ConfigurationData {
    const val applicationId = "com.kuzudisli.gurme"
    const val compileSdk = 34
    const val buildToolsVersion = "30.0.3"
    const val minSdk = 24
    const val targetSdk= 33
    const val versionCode = 1
    const val versionName = "1.0"
    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    val sourceCompatibility = JavaVersion.VERSION_11
    val targetCompatibility = JavaVersion.VERSION_11
    const val jvmTarget = "11"
}