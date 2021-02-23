package com.gadsphasetwoproject.domain.room.repository

import com.gadsphasetwoproject.data.networkCalls.LearnerHoursRemoteDataSource
import com.gadsphasetwoproject.domain.room.dao.LearningHoursDao
import com.gadsphasetwoproject.presentation.utils.performGetOperation
import javax.inject.Inject

class LearnerHoursRepository @Inject constructor(
    private val remoteDataSource: LearnerHoursRemoteDataSource,
    private val localDataSource: LearningHoursDao
) {

    fun getLearnersHours() = performGetOperation(
        databaseQuery = { localDataSource.getAllLearnersHour() },
        networkCall = { remoteDataSource.getLearnersHours() },
        saveCallResult = { localDataSource.insertHour(it) }
    )

}