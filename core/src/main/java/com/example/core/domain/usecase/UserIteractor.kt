package com.example.core.domain.usecase

import com.example.core.data.Resource
import com.example.core.domain.model.User
import com.example.core.domain.repository.IUserRepository
import kotlinx.coroutines.flow.Flow

class UserIteractor(private val userRepository: IUserRepository ): UserUseCase {
    override fun getAllUser() = userRepository.getAllUser()

}