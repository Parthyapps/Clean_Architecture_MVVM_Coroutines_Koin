package com.clean_arch_mvvm_coroutines.data.remote.useCase

import com.clean_arch_mvvm_coroutines.data.remote.model.Post
import com.clean_arch_mvvm_coroutines.repository.AppRepository

class GetPostsUseCase constructor(
    private val postsRepository: AppRepository
) : UseCase<List<Post>, Any?>() {

    override suspend fun run(params: Any?): List<Post> {
        return postsRepository.getPosts()
    }

}