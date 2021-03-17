package com.hari.sample.ui.employee

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hari.sample.model.Employee
import com.hari.sample.model.repository.EmployeeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EmployeesViewModel @Inject constructor(
    private val employeeRepository: EmployeeRepository,
) : ViewModel() {
    val employees: Flow<List<Employee>> = employeeRepository.fetchEmployeesFlow()
    fun addEmployee() {
        viewModelScope.launch(Dispatchers.IO) {
            employeeRepository.insertEmployee(
                Employee.TEST_EMPLOYEE
            )
        }
    }
}