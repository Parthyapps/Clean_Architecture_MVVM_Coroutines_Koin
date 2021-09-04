package com.clean_arch_mvvm_coroutines.data.remote.useCase

import com.clean_arch_mvvm_coroutines.data.remote.model.ApiError

interface UseCaseResponse<Type> {

    fun onSuccess(result: Type)

    fun onError(apiError: ApiError?)
}