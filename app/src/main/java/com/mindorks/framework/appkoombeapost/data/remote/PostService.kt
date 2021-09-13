package com.mindorks.framework.appkoombeapost.data.remote

import com.mindorks.framework.appkoombeapost.data.entities.Data
import com.mindorks.framework.appkoombeapost.data.entities.Posts
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PostService {
    @GET("posts")
    suspend fun getAllPosts() : Response<Posts>

    @GET("post/{id}")
    suspend fun getPost(@Path("id") id: Int): Response<Data>
}