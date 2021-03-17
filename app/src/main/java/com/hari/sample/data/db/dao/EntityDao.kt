package com.hari.sample.data.db.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import com.hari.sample.data.db.entity.AppEntity


interface EntityDao<T : AppEntity> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(t: T)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(t: List<T>)

    @Update
    suspend fun update(t: T)

    @Delete
    suspend fun delete(t: T)
}