package com.gadsphasetwoproject.room.repository

import com.gadsphasetwoproject.networkCalls.LearnerHoursRemoteDataSource
import com.gadsphasetwoproject.room.dao.LearningHoursDao
import com.gadsphasetwoproject.utils.performGetOperation
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