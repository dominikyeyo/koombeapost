package com.mindorks.framework.appkoombeapost.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "data")
data class Data(
    val email: String,
    val name: String,
    val posts: List<Post>,
    val profile_pic: String,
    @PrimaryKey
    val uid: String
)