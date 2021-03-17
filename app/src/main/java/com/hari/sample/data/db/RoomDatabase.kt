package com.hari.sample.data.db

import androidx.room.withTransaction
import com.hari.sample.data.db.dao.UserDao
import com.hari.sample.data.db.entity.UserEntity
import com.hari.sample.data.db.mappers.UserEntityToUser
import com.hari.sample.model.User
import com.hari.sample.model.forLists
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class RoomDatabase @Inject constructor(
    private val cacheDatabase: CacheDatabase,
    private val userDao: UserDao,
    private val userMapper: UserEntityToUser,
) : UserDatabase {
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
}