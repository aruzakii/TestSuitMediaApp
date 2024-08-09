package com.example.core.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.core.data.source.local.entity.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAllUser(): Flow<List<UserEntity>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(github: List<UserEntity>)
}