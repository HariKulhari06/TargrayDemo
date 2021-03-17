package com.hari.sample.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hari.sample.data.db.dao.EmployeeDao
import com.hari.sample.data.db.dao.UserDao
import com.hari.sample.data.db.entity.EmployeeEntity
import com.hari.sample.data.db.entity.UserEntity

@Database(
    entities = [
        UserEntity::class,
        EmployeeEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class CacheDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun employeeDao(): EmployeeDao
}