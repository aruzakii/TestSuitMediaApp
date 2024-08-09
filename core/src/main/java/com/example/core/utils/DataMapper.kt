package com.example.core.utils

import com.example.core.data.source.local.entity.UserEntity
import com.example.core.data.source.remote.response.DataItem
import com.example.core.domain.model.User

object DataMapper {
    fun mapResponsesToEntities(input: List<DataItem>): List<UserEntity> {
        val userList = ArrayList<UserEntity>()
        input.map {
            val user = UserEntity(
              id = it.id,
              email = it.email,
              firstName = it.firstName,
                lastName = it.lastName,
                avatar = it.avatar
            )
            userList.add(user)
        }
        return userList
    }

    fun mapEntitiesToDomain(input: List<UserEntity>): List<User> =
        input.map {
            User(
                id = it.id,
                email = it.email,
                firstName = it.firstName,
                lastName = it.lastName,
                avatar = it.avatar
            )
        }

    fun mapDomainToEntity(input: User) = UserEntity(
        id = input.id,
        email = input.email,
        firstName = input.firstName,
        lastName = input.lastName,
        avatar = input.avatar
    )
}