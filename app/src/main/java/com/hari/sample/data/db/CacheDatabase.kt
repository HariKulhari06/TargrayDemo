package com.hari.sample.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hari.sample.data.db.dao.UserDao
import com.hari.sample.data.db.entity.UserEntity

@Database(
    entities = [
        UserEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class CacheDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}