package com.gadsphasetwoproject.domain.repository

import com.gadsphasetwoproject.core.Result
import com.gadsphasetwoproject.presentation.model.HoursModel
import com.gadsphasetwoproject.presentation.model.IqModel
import kotlinx.coroutines.flow.Flow


interface GadsRepository {
    suspend fun getLearnersHours(): Flow<Result<List<HoursModel>>>
    suspend fun getLearnersIq(): Flow<Result<List<IqModel>>>
}