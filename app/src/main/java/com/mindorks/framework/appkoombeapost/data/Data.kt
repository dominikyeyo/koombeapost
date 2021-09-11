package com.mindorks.framework.appkoombeapost.data

data class Data(
    val email: String,
    val name: String,
    val posts: List<Post>,
    val profile_pic: String,
    val uid: String
)