package com.hari.sample.data

import com.hari.sample.data.db.UserDatabase
import com.hari.sample.data.db.entity.UserEntity
import com.hari.sample.data.network.mappers.ServerResultToUserEntityMapper
import com.hari.sample.data.network.services.UserService
import com.hari.sample.model.ErrorResult
import com.hari.sample.model.Success
import com.hari.sample.model.User
import com.hari.sample.model.forLists
import com.hari.sample.model.repository.UserRepository
import com.hari.sample.utils.ext.toResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userService: UserService,
    private val userDatabase: UserDatabase,
    private val networkResultMapper: ServerResultToUserEntityMapper,
) : UserRepository {

    override suspend fun syncUsersData() {
        try {
            val result = userService.getUsers(RESULT_SIZE)
                .execute()
                .toResult()

            when (result) {
                is Success -> {
                    val userEntities: List<UserEntity> =
                        networkResultMapper.forLists().invoke(result.data.results)
                    userDatabase.insertUsers(userEntities)
                }
                is ErrorResult -> {
                    result.throwable.printStackTrace()
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun getUsersFlow(): Flow<List<User>> {
        return userDatabase.fetchUsersFlow()
    }


    companion object {
        private val RESULT_SIZE = 100
    }
}