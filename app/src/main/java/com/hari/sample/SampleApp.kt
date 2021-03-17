package com.hari.sample

import android.app.Application
import com.hari.sample.di.initializer.AppInitializers
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class SampleApp : Application(){

    @Inject
    lateinit var initializers: AppInitializers

    override fun onCreate() {
        super.onCreate()
        initializers.initialize(this)
    }
}