package com.hari.sample.data.db.mappers

import com.hari.sample.data.db.entity.EmployeeEntity
import com.hari.sample.model.Employee
import com.hari.sample.model.Mapper
import javax.inject.Inject

class EmployeeToEmployeeEntity @Inject constructor() : Mapper<Employee, EmployeeEntity> {
    override suspend fun map(from: Employee): EmployeeEntity {
        return EmployeeEntity(
            id = from.id,
            name = from.name,
            address = from.address,
            gender = from.gender,
            age = from.age,
            salary = from.salary
        )
    }
}