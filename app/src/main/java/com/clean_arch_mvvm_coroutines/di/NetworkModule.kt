package com.clean_arch_mvvm_coroutines.di

import com.clean_arch_mvvm_coroutines.BuildConfig
import com.clean_arch_mvvm_coroutines.data.remote.api.ApiService
import com.clean_arch_mvvm_coroutines.data.remote.useCase.GetPostsUseCase
import com.clean_arch_mvvm_coroutines.repository.AppRepository
import com.clean_arch_mvvm_coroutines.repository.repoImpl.AppRepoImpl
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

private const val TIME_OUT = 30L

val NetworkModule = module {

    single { createService(get()) }

    single { createRetrofitClient(get()) }

    single { createOkHttpClient() }

    single { MoshiConverterFactory.create() }

    single { Moshi.Builder().build() }
}

fun createOkHttpClient(): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
    return OkHttpClient.Builder()
        .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
        .readTimeout(TIME_OUT, TimeUnit.SECONDS)
        .addInterceptor(httpLoggingInterceptor).build()
}

fun createRetrofitClient(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create()).build()
}

fun createService(retrofit: Retrofit): ApiService {
    return retrofit.create(ApiService::class.java)
}

fun createPostRepository(apiService: ApiService): AppRepository {
    return AppRepoImpl(apiService)
}

fun createGetPostsUseCase(postsRepository: AppRepository): GetPostsUseCase {
    return GetPostsUseCase(postsRepository)
}