package com.gadsphasetwoproject.domain.usecase

import com.gadsphasetwoproject.core.Result
import com.gadsphasetwoproject.core.mapData
import com.gadsphasetwoproject.domain.repository.GadsRepository
import com.gadsphasetwoproject.presentation.model.HoursModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetLearningHours @Inject constructor(
    private val repo: GadsRepository
) : UseCase<List<HoursModel>>() {
    override suspend fun buildUseCase(): Flow<Result<List<HoursModel>>> {
        return repo.getLearnersHours().map {
            it.mapData { data ->
                data.map {
                    HoursModel(
                        it.name,
                        it.hours,
                        it.country,
                        it.badgeUrl
                    )
                }
            }
        }
    }
}