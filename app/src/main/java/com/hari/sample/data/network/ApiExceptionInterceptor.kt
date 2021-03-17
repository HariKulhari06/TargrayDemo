package com.hari.sample.data.network

import android.content.Context
import android.net.ConnectivityManager
import com.hari.sample.data.network.exception.NoConnectivityException
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class ApiExceptionInterceptor @Inject constructor(
    @ApplicationContext val context: Context
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        if (!isConnected()) {
            throw NoConnectivityException()
        }

        val builder: Request.Builder = chain.request().newBuilder()
        val response = chain.proceed(builder.build())

        return response
    }

    private fun isConnected(): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = connectivityManager.activeNetworkInfo
        return netInfo != null && netInfo.isConnected
    }
}


