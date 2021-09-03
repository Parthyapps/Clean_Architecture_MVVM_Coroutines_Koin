package com.clean_arch_mvvm_coroutines.data.remote.api

import com.clean_arch_mvvm_coroutines.data.remote.model.Post
import retrofit2.http.GET

interface ApiService {

    @GET("/posts")
    suspend fun getPosts():List<Post>
}