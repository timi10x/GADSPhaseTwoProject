package com.gadsphasetwoproject.model.viewModel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.gadsphasetwoproject.room.repository.LearnerHoursRepository


class LearnerHoursViewModel @ViewModelInject constructor(
    private val repository: LearnerHoursRepository
) : ViewModel() {
    val learnerHours = repository.getLearnersHours()
}
