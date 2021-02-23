package com.gadsphasetwoproject.domain.room.repository

import com.gadsphasetwoproject.data.networkCalls.SkillIqRemoteDataSource
import com.gadsphasetwoproject.domain.room.dao.SkillIqDao
import com.gadsphasetwoproject.presentation.utils.performGetOperation
import javax.inject.Inject

class SkillIqRepository @Inject constructor(
    private val remoteDataSource: SkillIqRemoteDataSource,
    private val localDataSource: SkillIqDao
) {
    fun getUserIq() = performGetOperation(
        databaseQuery = { localDataSource.getAllLearnersIq() },
        networkCall = { remoteDataSource.getSkillIq() },
        saveCallResult = { localDataSource.insertIq(it) }
    )
}