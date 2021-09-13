package com.mindorks.framework.appkoombeapost.data.repository

import com.mindorks.framework.appkoombeapost.data.local.PostDao
import com.mindorks.framework.appkoombeapost.data.remote.PosterRemoteDataSource
import com.mindorks.framework.appkoombeapost.utils.performGetOperation
import javax.inject.Inject

class PostRepository @Inject constructor(
    private val remoteDataSource: PosterRemoteDataSource,
    private val localDataSource: PostDao
) {
    fun getPoster(id: Int) = performGetOperation(
        databaseQuery = { localDataSource.getPost(id) },
        networkCall = { remoteDataSource.getPost(id) },
        saveCallResult = { localDataSource.insert(it) }
    )


    fun getPosters() = performGetOperation(
        databaseQuery = { localDataSource.getAllPosts() },
        networkCall = { remoteDataSource.getPosters() },
        saveCallResult = { localDataSource.insertAll(it.data) }
    )

}