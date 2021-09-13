package com.mindorks.framework.appkoombeapost.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "post")
data class Post(
    val date: String,
    @PrimaryKey
    val id: Int,
    val pics: List<String>
)