package com.hari.sample.di.initializer

import android.app.Application
import com.hari.sample.di.appinitializer.AppInitializer

import javax.inject.Inject

class AppInitializers @Inject constructor(
    private val initializers: Set<@JvmSuppressWildcards AppInitializer>
) {
    fun initialize(application: Application) {
        initializers.forEach {
            it.initialize(application)
        }
    }
}
