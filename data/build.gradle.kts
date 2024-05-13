import com.kuzudisli.gurme.ConfigurationData
import com.kuzudisli.gurme.Libs

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-parcelize")
    id("io.realm.kotlin")
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

    implementation(project(":domain"))

    implementation(Libs.coreKtx)
    implementation(Libs.appcompat)
    implementation(Libs.material)
    testImplementation(Libs.junit)
    androidTestImplementation(Libs.androidJUnit)
    androidTestImplementation(Libs.espressoCore)

    implementation(Libs.viewModel)
    implementation(Libs.lifecycle)

    implementation(Libs.retrofit)
    implementation(Libs.retrofitRxJava)
    implementation(Libs.gsonConverter)
    implementation(Libs.okhttp)
    implementation(Libs.loggingInterceptor)

    implementation(Libs.coroutinesAndroid)
    implementation(Libs.coroutinesCore)
    implementation(Libs.coroutinesPlayServices)

    implementation(Libs.koinCore)
    implementation(Libs.koinAndroid)
    implementation(Libs.koinNavigation)
    implementation(Libs.koinWorkManagerr)
    testImplementation(Libs.koinTest)
    implementation(Libs.realmDB)

//    implementation (platform(Libs.firebaseBom)) // Use BoM for Firebase
//    implementation(Libs.firebaseAuth)
//    implementation(Libs.firebaseFirestore)
//    implementation(Libs.firebaseStorage)
//    implementation(Libs.firebaseMessaging)
//    implementation(Libs.firebaseUIAuth)
//    implementation(Libs.firebaseUIFirestore)
    implementation(Libs.firebaseAuth)
    implementation(Libs.firebaseFirestore)
    implementation(Libs.firebaseStorage)
    implementation(Libs.firebaseMessaging)
}
