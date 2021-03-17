package com.hari.sample.model

import com.google.gson.annotations.SerializedName



data class ApiError(
    @SerializedName("error_code")
    val errorCode: String,
    @SerializedName("http_status_code")
    val httpStatusCode: Int,
    @SerializedName("message")
    val message: String
)