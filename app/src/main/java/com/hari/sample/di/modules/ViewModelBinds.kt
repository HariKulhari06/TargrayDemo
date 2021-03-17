package com.hari.sample.di.modules

import com.hari.sample.data.UserRepositoryImpl
import com.hari.sample.data.db.UserDatabase
import com.hari.sample.data.db.RoomDatabase
import com.hari.sample.model.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
abstract class ViewModelBinds {
    @Binds
    abstract fun bindUserRepository(impl: UserRepositoryImpl): UserRepository
}