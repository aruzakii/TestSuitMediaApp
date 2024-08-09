package com.example.core.domain.repository

import com.example.core.data.Resource
import com.example.core.domain.model.User
import kotlinx.coroutines.flow.Flow

interface IUserRepository {
    fun getAllUser(): Flow<Resource<List<User>>>
}