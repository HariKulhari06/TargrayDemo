package com.hari.sample.data.db.mappers

import com.hari.sample.data.db.entity.EmployeeEntity
import com.hari.sample.model.Employee
import com.hari.sample.model.Mapper
import javax.inject.Inject

class EmployeeEntityToEmployee @Inject  constructor(): Mapper<EmployeeEntity, Employee> {
    override suspend fun map(from: EmployeeEntity): Employee {
        return Employee(
            id = from.id,
            name = from.name,
            address = from.address,
            gender = from.gender,
            age = from.age,
            salary = from.salary
        )
    }
}