package com.hari.sample.model.repository

import com.hari.sample.model.Employee
import kotlinx.coroutines.flow.Flow

interface EmployeeRepository {
    suspend fun insertEmployee(employee: Employee)
    suspend fun update(employee: Employee)
    fun getEmployee(empId: Int): Flow<Employee>
    fun fetchEmployeesFlow(): Flow<List<Employee>>
}