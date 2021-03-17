package com.hari.sample.data.network

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class AuthInterceptor @Inject constructor(
    @ApplicationContext val context: Context
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()

        requestBuilder.addHeader("Content-Type", "application/json")
        requestBuilder.addHeader("accept", "application/json")
        requestBuilder.addHeader("Accept-Language", "En")
        // If token has been saved, add it to the request
        requestBuilder.addHeader("Authorization", "Bearer ")

        return chain.proceed(requestBuilder.build())
    }

}