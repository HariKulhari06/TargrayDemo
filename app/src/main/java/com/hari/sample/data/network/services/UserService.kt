package com.hari.sample.data.network.services

import com.hari.sample.data.network.response.UserListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface UserService {
    @GET("api/")
    fun getUsers(@Query("results") size: Int): Call<UserListResponse>
}