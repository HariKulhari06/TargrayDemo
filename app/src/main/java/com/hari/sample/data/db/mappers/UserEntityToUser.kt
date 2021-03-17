package com.hari.sample.data.db.mappers

import com.hari.sample.data.db.entity.UserEntity
import com.hari.sample.model.Mapper
import com.hari.sample.model.User
import javax.inject.Inject

class UserEntityToUser @Inject constructor() : Mapper<UserEntity, User> {
    override suspend fun map(from: UserEntity): User {
        return User(
            userId = from.userId,
            name = from.name,
            gender = from.gender,
            age = from.age,
            phoneNumber = from.phoneNumber,
            emailAddress = from.emailAddress,
            cellNumber = from.cellNumber,
            address = from.address,
            profilePic = from.profilePic
        )
    }
}