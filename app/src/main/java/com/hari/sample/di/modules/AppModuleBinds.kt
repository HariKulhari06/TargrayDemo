package com.hari.sample.di.modules

import com.hari.sample.data.db.EmployeeDatabase
import com.hari.sample.data.db.RoomDatabase
import com.hari.sample.data.db.UserDatabase
import com.hari.sample.di.appinitializer.AppInitializer
import com.hari.sample.di.initializer.ThemeInitializer
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModuleBinds {
    @Binds
    @IntoSet
    abstract fun provideThemeInitializer(bind: ThemeInitializer): AppInitializer

    @Binds
    abstract fun bindUserDatabase(impl: RoomDatabase): UserDatabase

    @Binds
    abstract fun bindEmployeeDatabase(impl: RoomDatabase): EmployeeDatabase
}