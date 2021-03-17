package com.hari.sample.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.hari.sample.data.db.entity.EmployeeEntity
import kotlinx.coroutines.flow.Flow


@Dao
abstract class EmployeeDao : EntityDao<EmployeeEntity> {
    @Query("SELECT * FROM employee ORDER BY id ASC")
    abstract fun getEmployeesFlow(): Flow<List<EmployeeEntity>>

    @Query("SELECT * FROM employee WHERE id = :id LIMIT 1")
    abstract fun getEmployeeFlow(id: Int): Flow<EmployeeEntity>

    @Query("DELETE FROM users")
    abstract fun deleteAll()
}