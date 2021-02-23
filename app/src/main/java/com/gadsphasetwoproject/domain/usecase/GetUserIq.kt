package com.gadsphasetwoproject.domain.usecase

import com.gadsphasetwoproject.core.Result
import com.gadsphasetwoproject.core.mapData
import com.gadsphasetwoproject.domain.repository.GadsRepository
import com.gadsphasetwoproject.presentation.model.IqModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetUserIq @Inject constructor(
    private val repo: GadsRepository
) : UseCase<List<IqModel>>() {
    override suspend fun buildUseCase(): Flow<Result<List<IqModel>>> {
        return repo.getLearnersIq().map {
            it.mapData { data ->
                data.map {
                    IqModel(
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