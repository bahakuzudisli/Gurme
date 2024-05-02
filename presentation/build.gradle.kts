import com.kuzudisli.gurme.ConfigurationData
import com.kuzudisli.gurme.Libs

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.kuzudisli.presentation"
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
    implementation(Libs.coreKtx)
    implementation(Libs.appcompat)
    implementation(Libs.material)
    implementation(Libs.constraintLayout)
    implementation(Libs.navigationFragmentKtx)
    implementation(Libs.navigationUiKtx)
    testImplementation(Libs.junit)
    androidTestImplementation(Libs.androidJUnit)
    androidTestImplementation(Libs.espressoCore)

}