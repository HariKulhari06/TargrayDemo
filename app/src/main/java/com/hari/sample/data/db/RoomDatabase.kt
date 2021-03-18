package com.hari.sample.data.db

import androidx.room.withTransaction
import com.hari.sample.data.db.dao.EmployeeDao
import com.hari.sample.data.db.dao.UserDao
import com.hari.sample.data.db.entity.UserEntity
import com.hari.sample.data.db.mappers.EmployeeEntityToEmployee
import com.hari.sample.data.db.mappers.EmployeeToEmployeeEntity
import com.hari.sample.data.db.mappers.UserEntityToUser
import com.hari.sample.model.Employee
import com.hari.sample.model.User
import com.hari.sample.model.forLists
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class RoomDatabase @Inject constructor(
    private val cacheDatabase: CacheDatabase,
    private val userDao: UserDao,
    private val employeeDao: EmployeeDao,
    private val userMapper: UserEntityToUser,
    private val employeeMapper: EmployeeEntityToEmployee,
    private val employeeEntityMapper: EmployeeToEmployeeEntity,
) : UserDatabase, EmployeeDatabase {
    override suspend fun insertUsers(userEntities: List<UserEntity>) {
        cacheDatabase.withTransaction {
            userDao.deleteAll()
            userDao.insert(userEntities)
        }
    }

    override fun fetchUsersFlow(): Flow<List<User>> {
        return userDao
            .getUsers()
            .map { userEntities -> userMapper.forLists().invoke(userEntities) }
    }

    override suspend fun insertEmployee(employee: Employee) {
        employeeDao.insert(employeeEntityMapper.map(employee))
    }

    override suspend fun update(employee: Employee) {
        employeeDao.update(employeeEntityMapper.map(employee))
    }

    override fun getEmployee(empId: Int): Flow<Employee> {
        return employeeDao
            .getEmployeeFlow(empId)
            .distinctUntilChanged()
            .map { entity ->
                employeeMapper.map(entity)
            }
    }

    override fun fetchEmployeesFlow(): Flow<List<Employee>> {
        return employeeDao
            .getEmployeesFlow()
            .distinctUntilChanged()
            .map { entities ->
                employeeMapper.forLists().invoke(entities)
            }
    }

    override suspend fun updateEmployee(employee: Employee) {
       /* employeeDao.updateEmployee(
            id = employee.id,
            name = employee.name!!,
            address = employee.address!!,
            age = employee.age!!,
            salary = employee.salary!!,
            gender = employee.gender!!
        )*/

        employeeDao.update(employeeEntityMapper.map(employee))
    }
}