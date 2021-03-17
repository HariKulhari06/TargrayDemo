package com.hari.sample.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.hari.sample.data.db.entity.UserEntity
import kotlinx.coroutines.flow.Flow


@Dao
abstract class UserDao : EntityDao<UserEntity> {
    @Query("SELECT * FROM users ORDER BY name ASC")
    abstract fun getUsers(): Flow<List<UserEntity>>

    @Query("DELETE FROM users")
    abstract fun deleteAll()
}