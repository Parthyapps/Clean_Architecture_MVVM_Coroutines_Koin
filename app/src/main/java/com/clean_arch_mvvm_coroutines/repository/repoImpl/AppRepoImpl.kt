package com.clean_arch_mvvm_coroutines.repository.repoImpl

import com.clean_arch_mvvm_coroutines.data.remote.api.ApiService
import com.clean_arch_mvvm_coroutines.data.remote.model.Post
import com.clean_arch_mvvm_coroutines.repository.AppRepository

class AppRepoImpl(private val apiService: ApiService) : AppRepository {

    override suspend fun getPosts(): List<Post> {
        return apiService.getPosts()
    }
}