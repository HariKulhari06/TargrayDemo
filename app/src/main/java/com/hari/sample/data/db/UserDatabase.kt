package com.hari.sample.data.db

import com.hari.sample.data.db.entity.UserEntity
import com.hari.sample.model.User
import kotlinx.coroutines.flow.Flow

interface UserDatabase {
    suspend fun insertUsers(userEntities: List<UserEntity>)
     fun fetchUsersFlow(): Flow<List<User>>
}