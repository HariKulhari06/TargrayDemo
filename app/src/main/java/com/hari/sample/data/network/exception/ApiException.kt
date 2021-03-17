package com.hari.sample.data.network.exception

import com.hari.sample.model.ApiError

class ApiException(val apiError: ApiError) : Throwable(apiError.message)