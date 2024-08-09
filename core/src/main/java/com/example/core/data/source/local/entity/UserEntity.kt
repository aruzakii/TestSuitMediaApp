package com.example.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo("email")
    val email: String,

    @ColumnInfo("first_name")
    val firstName: String,

    @ColumnInfo("last_name")
    val lastName: String,

    @ColumnInfo("avatar")
    val avatar: String,

    )