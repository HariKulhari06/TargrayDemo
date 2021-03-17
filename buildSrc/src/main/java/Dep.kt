package com.hari.sample

object Dep {
    object Jetpack {
        const val appcompat = "androidx.appcompat:appcompat:1.2.0"
        const val startup = "androidx.startup:startup-runtime:1.0.0"
        const val browser = "androidx.browser:browser:1.3.0"
        const val dataStore = "androidx.datastore:datastore-preferences:1.0.0-alpha06"
        const val lifecycle = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.0"
        const val roomRuntime= "androidx.room:room-runtime:2.2.6"
        const val roomCompiler = "androidx.room:room-compiler:2.2.6"
        const val room = "androidx.room:room-ktx:2.2.6"
    }

    object Kotlin {
        const val bom = "org.jetbrains.kotlin:kotlin-bom:1.4.30"
        const val plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.30"
        const val serializationPlugin = "org.jetbrains.kotlin:kotlin-serialization:1.4.30"
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:1.4.30"
        const val stdlibJdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.4.30"
        const val reflect = "org.jetbrains.kotlin:kotlin-reflect"
    }

    object Coroutines {
        const val bom = "org.jetbrains.kotlinx:kotlinx-coroutines-bom:1.4.2"
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.2"
        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.4.2"
    }

    object Serialization {
        const val core = "org.jetbrains.kotlinx:kotlinx-serialization-core:1.0.1"
    }

    object KotlinTest {
        const val common = "org.jetbrains.kotlin:kotlin-test-common"
        const val annotationCommon = "org.jetbrains.kotlin:kotlin-test-annotations-common"
        const val junit = "org.jetbrains.kotlin:kotlin-test-junit"
    }

    object PlayServices {
        const val plugin = "com.google.gms:google-services:4.3.5"
    }

    const val datetime = "org.jetbrains.kotlinx:kotlinx-datetime:0.1.1"
    const val ktlint = "com.pinterest:ktlint:0.40.0"

    object Dagger {
        private const val VERSION="2.33-beta"
        const val plugin = "com.google.dagger:hilt-android-gradle-plugin:$VERSION"
        const val hiltAndroid = "com.google.dagger:hilt-android:$VERSION"
        const val hiltAndroidTesting = "com.google.dagger:hilt-android-testing:$VERSION"
        const val hiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:$VERSION"
    }

    object Accompanist {
        const val insets = "dev.chrisbanes.accompanist:accompanist-insets:0.6.0"
        const val coil = "dev.chrisbanes.accompanist:accompanist-coil:0.6.0"
    }

    object FirebaseCrashlytics {
        const val plugin = "com.google.firebase:firebase-crashlytics-gradle:2.5.0"
        const val android = "com.google.firebase:firebase-crashlytics:17.3.1"
    }

    const val firebaseAuth = "dev.gitlive:firebase-auth:1.2.0"
    const val firebaseMessaging = "com.google.firebase:firebase-messaging-ktx:21.0.1"

    object AndroidX {
        const val core = "androidx.core:core-ktx:1.5.0-beta01"
        const val appCompat = "androidx.appcompat:appcompat:1.2.0"
        const val material = "com.google.android.material:material:1.3.0"
        const val constraintlayout = "androidx.constraintlayout:constraintlayout:2.0.4"
        const val fragment = "androidx.fragment:fragment-ktx:1.3.0"
        const val activity = "androidx.activity:activity-ktx:1.2.0"
        const val lifecycle = "androidx.lifecycle:lifecycle-livedata-ktx:2.3.0"
        const val hiltCommon = "androidx.hilt:hilt-common:1.0.0-alpha03"
        const val hiltLifeCycleViewModel = "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03"
        const val swiperefreshlayout = "androidx.swiperefreshlayout:swiperefreshlayout:1.1.0"


        object Test {
            const val ext = "androidx.test.ext:junit:1.1.2"
            const val espresso = "androidx.test.espresso:espresso-core:3.3.0"
        }
    }

    object Navigation {
        const val VERSION = "2.3.4"
        val runtimeKtx = "androidx.navigation:navigation-runtime-ktx:$VERSION"
        val fragmentKtx = "androidx.navigation:navigation-fragment-ktx:$VERSION"
        val uiKtx = "androidx.navigation:navigation-ui-ktx:$VERSION"
        val dynamicFeaturesFragment =
            "androidx.navigation:navigation-dynamic-features-fragment:2.3.0-SNAPSHOT"
        val dynamicFeaturesRuntime =
            "androidx.navigation:navigation-dynamic-features-runtime:2.3.0-SNAPSHOT"
    }


    object Retrofit{
        val retrofit = "com.squareup.retrofit2:retrofit:2.9.0"
        val mock = "com.squareup.retrofit2:retrofit-mock:2.9.0"
        val okhttp3 = "com.squareup.okhttp3:okhttp:4.9.0"
        val interceptor = "com.squareup.okhttp3:logging-interceptor:4.9.0"
        val gson = "com.squareup.retrofit2:converter-gson:2.9.0"
    }

    object Picasso{
        val picasso = "com.squareup.picasso:picasso:2.71828"
    }
}
