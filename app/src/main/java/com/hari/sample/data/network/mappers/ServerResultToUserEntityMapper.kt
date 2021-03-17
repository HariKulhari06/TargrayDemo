package com.hari.sample.data.network.mappers

import com.hari.sample.data.db.entity.UserEntity
import com.hari.sample.data.network.response.Result
import com.hari.sample.model.Mapper
import javax.inject.Inject

class ServerResultToUserEntityMapper @Inject constructor() : Mapper<Result, UserEntity> {
    override suspend fun map(from: Result): UserEntity {
        return UserEntity(
            userId = from.id.value,
            name = from.name.title+" " + from.name.first+" " + from.name.last,
            age = from.dob.age,
            cellNumber = from.cell,
            phoneNumber = from.phone,
            gender = from.gender,
            emailAddress = from.email,
            address = from.location.getFullAddress(),
            profilePic = from.picture.thumbnail
        )
    }
}