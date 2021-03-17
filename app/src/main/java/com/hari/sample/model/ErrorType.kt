package com.hari.sample.model


enum class ErrorType(val errorCode: Int) {
    BAD_REQUEST(400),
    UNAUTHORIZED(401),
    FORBIDDEN(403),
    NOT_FOUND(404),
    NOT_ALLOWED(405),
    NOT_ACCEPTABLE(406),
    SYSTEM_ERROR(500),
    OTHER(-1);

    companion object {
        fun getErrorType(errorCode: Int) = values()
            .firstOrNull { error ->
                error.errorCode == errorCode
            } ?: OTHER

    }
}