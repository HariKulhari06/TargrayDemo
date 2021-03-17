import com.hari.sample.Dep
import com.hari.sample.Packages
import com.hari.sample.Versions

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdkVersion(Versions.androidCompileSdkVersion)
    defaultConfig {
        applicationId = Packages.name
        minSdkVersion(Versions.androidMinSdkVersion)
        targetSdkVersion(Versions.androidTargetSdkVersion)
        versionCode = Versions.androidVersionCode
        versionName = Versions.androidVersionName
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
        }
    }

    dataBinding {
        isEnabled = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(Dep.Kotlin.stdlib)
    implementation(Dep.AndroidX.core)
    implementation(Dep.AndroidX.appCompat)
    implementation(Dep.AndroidX.material)
    implementation(Dep.AndroidX.constraintlayout)
    implementation(Dep.AndroidX.lifecycle)
    implementation(Dep.AndroidX.swiperefreshlayout)

    implementation(Dep.Jetpack.room)
    kapt(Dep.Jetpack.roomCompiler)

    implementation(Dep.Navigation.fragmentKtx)
    implementation(Dep.Navigation.uiKtx)

    implementation(Dep.Dagger.hiltAndroid)
    kapt(Dep.Dagger.hiltAndroidCompiler)

    implementation(Dep.Retrofit.retrofit)
    implementation(Dep.Retrofit.mock)
    implementation(Dep.Retrofit.okhttp3)
    implementation(Dep.Retrofit.interceptor)
    implementation(Dep.Retrofit.gson)

    implementation(Dep.Picasso.picasso)
}