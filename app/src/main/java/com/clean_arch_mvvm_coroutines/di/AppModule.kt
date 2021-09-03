package com.clean_arch_mvvm_coroutines.di

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val AppModule = module {

   // viewModel {}

  //  single { createGetPostsUseCase(get()) }
    single { createPostRepository(get()) }
}