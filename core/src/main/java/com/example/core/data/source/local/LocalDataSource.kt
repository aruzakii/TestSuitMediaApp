package com.example.core.data.source.local

import com.example.core.data.source.local.entity.UserEntity
import com.example.core.data.source.local.room.UserDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val userDao: UserDao) {


    fun getAllUser(): Flow<List<UserEntity>> = userDao.getAllUser()


    suspend fun insertUser(userList: List<UserEntity>) {
        userDao.insertUser(userList)
    }

}