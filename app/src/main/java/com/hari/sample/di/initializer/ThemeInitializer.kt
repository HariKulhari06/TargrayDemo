package com.hari.sample.di.initializer

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.hari.sample.di.appinitializer.AppInitializer
import javax.inject.Inject


class ThemeInitializer @Inject constructor() :
    AppInitializer {
    override fun initialize(application: Application) {
        // for now app only support light mode
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }
}
