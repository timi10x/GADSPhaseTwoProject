package com.gadsphasetwoproject.data.networkCalls

class SkillIqRemoteDataSource(private val apiInterface: ApiInterface) : BaseDataSource() {

    suspend fun getSkillIq() = getResult {
        apiInterface.getLearnersIq()
    }
}