package com.hari.sample.data.db

import com.hari.sample.model.Employee
import kotlinx.coroutines.flow.Flow

interface EmployeeDatabase {
    suspend fun insertEmployee(employee: Employee)
    suspend fun update(employee: Employee)
    fun getEmployee(empId: Int):Flow<Employee>
    fun fetchEmployeesFlow(): Flow<List<Employee>>
    suspend fun updateEmployee(employee: Employee)
}