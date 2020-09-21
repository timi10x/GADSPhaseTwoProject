package com.gadsphasetwoproject.room.repository

import com.example.rickandmorty.utils.performGetOperation
import com.gadsphasetwoproject.networkCalls.LearnerHoursRemoteDataSource
import com.gadsphasetwoproject.room.dao.LearningHoursDao
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