package com.gadsphasetwoproject.networkCalls

class SubmitRemoteDataSource(private val apiInterface: ApiInterface) : BaseDataSource() {

    suspend fun submitInfo(
        email: String?,
        name: String?,
        lastname: String?,
        link: String?
    ) = getResult {
        apiInterface.submitProject(
            email,
            name,
            lastname,
            link
        )
    }
}