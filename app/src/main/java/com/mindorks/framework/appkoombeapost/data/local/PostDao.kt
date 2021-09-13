package com.mindorks.framework.appkoombeapost.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mindorks.framework.appkoombeapost.data.entities.Data

@Dao
interface PostDao {

    @Query("SELECT * FROM data")
    fun getAllPosts() : LiveData<List<Data>>

    @Query("SELECT * FROM data WHERE uid = :id")
    fun getPost(id: Int): LiveData<Data>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(posts: List<Data>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(post: Data)


}