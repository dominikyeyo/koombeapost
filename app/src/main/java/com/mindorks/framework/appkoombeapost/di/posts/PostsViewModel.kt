package com.mindorks.framework.appkoombeapost.di.posts

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.mindorks.framework.appkoombeapost.data.repository.PostRepository

class PostsViewModel @ViewModelInject constructor(
    private val repository: PostRepository
) : ViewModel() {

    val posts = repository.getPosters()
}