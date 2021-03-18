package com.hari.sample.data

import com.hari.sample.data.db.EmployeeDatabase
import com.hari.sample.model.Employee
import com.hari.sample.model.repository.EmployeeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class EmployeeRepositoryImpl @Inject constructor(
    private val employeeDatabase: EmployeeDatabase,
) : EmployeeRepository {
    override suspend fun insertEmployee(employee: Employee) {
        employeeDatabase.insertEmployee(employee)
    }

    override suspend fun update(employee: Employee) {
        employeeDatabase.update(employee)
    }

    override fun getEmployee(empId: Int): Flow<Employee> {
        return employeeDatabase.getEmployee(empId)
    }

    override fun fetchEmployeesFlow(): Flow<List<Employee>> {
        return employeeDatabase.fetchEmployeesFlow()
    }

    override suspend fun updateEmployee(employee: Employee) {
        employeeDatabase.update(employee)
    }
}