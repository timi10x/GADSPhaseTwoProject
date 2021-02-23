package com.gadsphasetwoproject.domain.room.repository

import com.gadsphasetwoproject.data.networkCalls.SubmitRemoteDataSource
import javax.inject.Inject

class SubmitProjectRepository @Inject constructor(
    private val remoteDataSource: SubmitRemoteDataSource
) {
    suspend fun submitProject(
        email: String?,
        name: String?,
        lastname: String?,
        link: String?
    ) = remoteDataSource.submitInfo(
        email,
        name,
        lastname,
        link
    )
}