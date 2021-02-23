package com.gadsphasetwoproject.domain.usecase

import com.gadsphasetwoproject.core.Result
import com.gadsphasetwoproject.core.mapData
import com.gadsphasetwoproject.domain.repository.GadsRepository
import com.gadsphasetwoproject.presentation.model.UserIq
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetUserIq @Inject constructor(
    private val repo: GadsRepository
) : UseCase<List<UserIq>>() {
    override suspend fun buildUseCase(): Flow<Result<List<UserIq>>> {
        return repo.getLearnersIq().map {
            it.mapData { data ->
                data.map {
                    UserIq(
                        it.name,
                        it.score,
                        it.country,
                        it.badgeUrl
                    )
                }
            }
        }
    }
}