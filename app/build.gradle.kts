import com.kuzudisli.gurme.ConfigurationData
import com.kuzudisli.gurme.Libs

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("androidx.navigation.safeargs.kotlin")
    id("kotlin-parcelize")
}

android {
    namespace = ConfigurationData.applicationId
    compileSdk = ConfigurationData.compileSdk

    defaultConfig {
        applicationId = ConfigurationData.applicationId
        minSdk = ConfigurationData.minSdk
        targetSdk = ConfigurationData.targetSdk
        versionCode = ConfigurationData.versionCode
        versionName = ConfigurationData.versionName

        testInstrumentationRunner = ConfigurationData.testInstrumentationRunner
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = ConfigurationData.sourceCompatibility
        targetCompatibility = ConfigurationData.targetCompatibility
    }
    kotlinOptions {
        jvmTarget = ConfigurationData.jvmTarget
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(project(":domain"))
    implementation(project(":data"))
    implementation(project(":presentation"))

    implementation(Libs.coreKtx)
    implementation(Libs.appcompat)
    implementation(Libs.material)
    implementation(Libs.constraintLayout)
    implementation(Libs.navigationFragmentKtx)
    implementation(Libs.navigationUiKtx)
    testImplementation(Libs.junit)
    androidTestImplementation(Libs.androidJUnit)
    androidTestImplementation(Libs.espressoCore)

    implementation(Libs.viewModel)
    implementation(Libs.lifecycle)

    implementation(Libs.koinCore)
    implementation(Libs.koinAndroid)
    implementation(Libs.koinNavigation)
    implementation(Libs.koinWorkManager)
    testImplementation(Libs.koinTest)

    implementation(Libs.retrofit)
    implementation(Libs.retrofitRxJava)
    implementation(Libs.gsonConverter)
    implementation(Libs.okhttp)
    implementation(Libs.loggingInterceptor)

    implementation(Libs.coroutinesAndroid)
    implementation(Libs.coroutinesCore)

    implementation(Libs.stepView)

    implementation(Libs.workRuntimeKtx)

    implementation (Libs.realmDB)
}