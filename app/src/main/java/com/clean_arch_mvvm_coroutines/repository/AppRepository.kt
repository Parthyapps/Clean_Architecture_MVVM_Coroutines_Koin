package com.clean_arch_mvvm_coroutines.repository

import com.clean_arch_mvvm_coroutines.data.remote.model.Post

interface AppRepository {
    suspend fun getPosts(): List<Post>
}
