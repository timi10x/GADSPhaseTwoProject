package com.gadsphasetwoproject.domain.usecase

import com.gadsphasetwoproject.core.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect


abstract class UseCase<T> {
    protected abstract suspend fun buildUseCase(): Flow<Result<T>>

    suspend fun execute(): Flow<Result<T>> {
        return buildUseCase()
    }

    suspend fun execute(onSuccess: (T) -> Unit, onError: (String) -> Unit = {}) {
        return buildUseCase().collect {
            when (it) {
                is Result.Success -> onSuccess(it.data)
                is Result.Error -> onError(it.message)
            }
        }
    }

    class None
}