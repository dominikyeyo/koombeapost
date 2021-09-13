package com.mindorks.framework.appkoombeapost.data.remote

import javax.inject.Inject

class PosterRemoteDataSource @Inject constructor(
    private val postService: PostService
): BaseDataSource() {

    suspend fun getPosters() = getResult { postService.getAllPosts() }
    suspend fun getPost(id: Int) = getResult { postService.getPost(id) }
}