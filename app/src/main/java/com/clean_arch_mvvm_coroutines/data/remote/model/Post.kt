package com.clean_arch_mvvm_coroutines.data.remote.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Post(
    var userId: Int,
    var id: Int,
    var title: String,
    var body: String
)