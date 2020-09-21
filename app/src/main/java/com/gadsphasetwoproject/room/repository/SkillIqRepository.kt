package com.gadsphasetwoproject.room.repository

import com.example.rickandmorty.utils.performGetOperation
import com.gadsphasetwoproject.networkCalls.SkillIqRemoteDataSource
import com.gadsphasetwoproject.room.dao.SkillIqDao
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