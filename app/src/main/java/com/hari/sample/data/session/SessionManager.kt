package com.hari.sample.data.session


interface SessionManager {
    fun saveAuthToken(token: String?)
    fun fetchAuthToken(): String?
}