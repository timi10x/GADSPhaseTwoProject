package com.gadsphasetwoproject.domain.repository

import com.gadsphasetwoproject.core.Result
import com.gadsphasetwoproject.presentation.model.User
import com.gadsphasetwoproject.presentation.model.UserIq
import kotlinx.coroutines.flow.Flow


interface GadsRepository {
    suspend fun getLearnersHours(): Flow<Result<List<User>>>
    suspend fun getLearnersIq(): Flow<Result<List<UserIq>>>
}