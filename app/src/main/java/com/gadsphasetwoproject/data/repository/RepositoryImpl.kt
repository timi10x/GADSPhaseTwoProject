package com.gadsphasetwoproject.data.repository

import com.gadsphasetwoproject.core.Result
import com.gadsphasetwoproject.data.networkCalls.ApiInterface
import com.gadsphasetwoproject.data.toDomainFlow
import com.gadsphasetwoproject.domain.repository.GadsRepository
import com.gadsphasetwoproject.presentation.model.HoursModel
import com.gadsphasetwoproject.presentation.model.IqModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val apiInterface: ApiInterface
) : GadsRepository {
    override suspend fun getLearnersHours(): Flow<Result<List<HoursModel>>> {
        return apiInterface.getLearnerHours().toDomainFlow()
    }

    override suspend fun getLearnersIq(): Flow<Result<List<IqModel>>> {
        return apiInterface.getLearnersIq().toDomainFlow()
    }

}