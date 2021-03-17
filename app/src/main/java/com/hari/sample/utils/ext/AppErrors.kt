package com.hari.sample.utils.ext

import androidx.annotation.StringRes
import com.google.gson.GsonBuilder
import com.hari.sample.R
import com.hari.sample.data.network.exception.ApiException
import com.hari.sample.data.network.exception.NoConnectivityException
import com.hari.sample.model.ApiError
import com.hari.sample.model.AppError
import com.hari.sample.model.ErrorType
import kotlinx.coroutines.TimeoutCancellationException
import retrofit2.HttpException


/**
 * Convert Throwable to AppError
 */
fun Throwable?.toAppError(): AppError? {
    this?.printStackTrace()
    return when (this) {
        null -> null
        is AppError -> this
        is NoConnectivityException -> AppError.ApiException.NoConnectivityException(this)
        is HttpException -> httpExceptionToAppError()
        is TimeoutCancellationException -> AppError.ApiException.NetworkException(this)
        else -> AppError.UnknownException(this)
    }
}

private fun HttpException.httpExceptionToAppError(): AppError {
    val errorResponse = response()
    return if (errorResponse != null) {
        val error = errorResponse.errorBody()?.string()
        if (error.isNullOrEmpty().not()) {
            try {
                val gson = GsonBuilder().setLenient().create()
                val adapter =
                    gson.getAdapter<ApiError>(
                        ApiError::class.java
                    )
                AppError.ApiException.ApiErrorException(ApiException(adapter.fromJson(error)))
            } catch (e: Exception) {
                AppError.UnknownException(e)
            }
        } else {
            when (ErrorType.getErrorType(response()!!.code())) {
                ErrorType.UNAUTHORIZED ->
                    AppError.ApiException.SessionNotFoundException(this)
                ErrorType.SYSTEM_ERROR ->
                    AppError.ApiException.ServerException(this)
                else ->
                    AppError.ApiException.NetworkException(this)
            }
        }
    } else {
        AppError.ApiException.UnknownException(this)
    }
}

/**
 * Convert AppError to String Resources
 */
@StringRes
fun AppError.stringRes() = when (this) {
    is AppError.ApiException.NetworkException -> R.string.error_network
    is AppError.ApiException.NoConnectivityException -> R.string.error_no_internet_connection
    is AppError.ApiException.ServerException -> R.string.error_server
    is AppError.ApiException.SessionNotFoundException -> R.string.error_unknown
    is AppError.ApiException.UnknownException -> R.string.error_unknown
    is AppError.UnknownException -> R.string.error_unknown
    else -> R.string.error_unknown
}



