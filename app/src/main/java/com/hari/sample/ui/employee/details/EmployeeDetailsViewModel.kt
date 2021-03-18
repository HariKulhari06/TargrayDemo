package com.hari.sample.ui.employee.details

import androidx.lifecycle.*
import com.hari.sample.model.Employee
import com.hari.sample.model.repository.EmployeeRepository
import com.hari.sample.utils.ext.requireValue
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EmployeeDetailsViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val employeeRepository: EmployeeRepository,
) : ViewModel() {
    private val employeeId = savedStateHandle.getLiveData("empId", -1)

    val employee = employeeId.switchMap { id ->
        if (id != -1) {
            employeeRepository.getEmployee(id).asLiveData(Dispatchers.IO)
        } else {
            liveData {
                emit(Employee.EMPTY)
            }
        }
    }

    fun saveEmployee(emp: Employee, func: () -> Unit) {
        viewModelScope.launch() {
            if (employee.requireValue().id == 0) {
                employeeRepository.insertEmployee(emp)
                func()
            } else {
                employeeRepository.updateEmployee(emp.copy(id = employee.requireValue().id))
                func()
            }
        }
    }
}