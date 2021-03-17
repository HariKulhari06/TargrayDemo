package com.hari.sample.di.modules

import com.hari.sample.BuildConfig
import com.hari.sample.data.network.UserRetrofitClient
import com.hari.sample.data.network.ApiExceptionInterceptor
import com.hari.sample.data.network.AuthInterceptor
import com.hari.sample.data.network.services.UserService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Singleton
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }
    }

    @Singleton
    @Provides
    fun provideHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
        apiExceptionInterceptor: ApiExceptionInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(apiExceptionInterceptor)
            .build()
    }


    @Singleton
    @Provides
    fun provideAuthenticationApiClient(
        authInterceptor: AuthInterceptor,
        loggingInterceptor: HttpLoggingInterceptor,
        apiExceptionInterceptor: ApiExceptionInterceptor
    ): UserRetrofitClient {
        return object : UserRetrofitClient("https://randomuser.me/") {
            override fun setOkHttpClientDefaults(builder: OkHttpClient.Builder) {
                super.setOkHttpClientDefaults(builder)
                builder.apply {
                    addInterceptor(loggingInterceptor)
                    addInterceptor(authInterceptor)
                    addInterceptor(apiExceptionInterceptor)
                }
            }
        }
    }

    @Singleton
    @Provides
    fun provideAuthenticationService(userRetrofitClient: UserRetrofitClient): UserService {
        return userRetrofitClient.apiService()
    }
}