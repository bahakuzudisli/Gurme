import com.kuzudisli.gurme.ConfigurationData
import com.kuzudisli.gurme.Libs

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-parcelize")
    id ("io.realm.kotlin")
}

android {
    namespace = "com.kuzudisli.data"
    compileSdk = ConfigurationData.compileSdk

    defaultConfig {
        minSdk = ConfigurationData.minSdk

        testInstrumentationRunner = ConfigurationData.testInstrumentationRunner
        consumerProguardFiles("consumer-rules.pro")
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

    implementation (project(":domain"))

    implementation(Libs.coreKtx)
    implementation(Libs.appcompat)
    implementation(Libs.material)
    testImplementation(Libs.junit)
    androidTestImplementation(Libs.androidJUnit)
    androidTestImplementation(Libs.espressoCore)

    implementation(Libs.retrofit)
    implementation(Libs.gsonConverter)
    implementation(Libs.okhttp)
    implementation(Libs.loggingInterceptor)

    implementation(Libs.coroutinesAndroid)
    implementation(Libs.coroutinesCore)

    implementation(Libs.koinCore)
    implementation(Libs.koinAndroid)
    implementation(Libs.koinNavigation)
    implementation(Libs.koinWorkManager)

    // Realm Database for Android (Kotlin) - https://realm.io/docs/java/latest
    implementation (Libs.realmDB)
    //implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.0")// If using coroutines with the SDK
}
