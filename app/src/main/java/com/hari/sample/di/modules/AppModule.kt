package com.hari.sample.di.modules

import android.content.Context
import androidx.room.Room
import com.hari.sample.data.db.CacheDatabase
import com.hari.sample.data.db.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun cacheDatabase(@ApplicationContext context: Context): CacheDatabase {
        return Room
            .databaseBuilder(context, CacheDatabase::class.java, "users.db")
            .build()
    }

    @Singleton
    @Provides
    fun provideUserDao(database: CacheDatabase): UserDao = database.userDao()
}

