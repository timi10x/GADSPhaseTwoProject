package com.gadsphasetwoproject.networkCalls

class SkillIqRemoteDataSource(private val apiInterface: ApiInterface) : BaseDataSource() {

    suspend fun getSkillIq() = getResult {
        apiInterface.getLearnersIq()
    }
}