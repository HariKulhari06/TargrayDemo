package com.hari.sample.di.appinitializer

import android.app.Application

interface AppInitializer {
    fun initialize(application: Application)
}
