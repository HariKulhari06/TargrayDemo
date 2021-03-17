package com.hari.sample.data.session

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SessionManagerImpl @Inject constructor(
    @ApplicationContext context: Context
) : SessionManager {

    private val prefs: SharedPreferences =
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    companion object {
        const val PREF_NAME = "_session"
        const val AUTH_TOKEN = "auth_token"
    }

    override fun saveAuthToken(token: String?) {
        val editor = prefs.edit()
        editor.putString(AUTH_TOKEN, token)
        editor.apply()
    }

    override fun fetchAuthToken(): String? {
        return prefs.getString(AUTH_TOKEN, null)
    }
}