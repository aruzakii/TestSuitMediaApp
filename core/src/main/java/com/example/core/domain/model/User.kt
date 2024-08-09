package com.example.core.domain.model

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User (
    var id: Int,

    val email: String,

    val firstName: String,

    val lastName: String,

    val avatar: String,


    ): Parcelable