package com.hari.sample.model.repository

import com.hari.sample.model.User
import kotlinx.coroutines.flow.Flow


interface UserRepository {
    suspend fun syncUsersData()
    fun getUsersFlow(): Flow<List<User>>
}