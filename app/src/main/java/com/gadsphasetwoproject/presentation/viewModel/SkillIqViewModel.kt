package com.gadsphasetwoproject.presentation.viewModel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.gadsphasetwoproject.domain.room.repository.SkillIqRepository

class SkillIqViewModel @ViewModelInject constructor(
    private val repository: SkillIqRepository
) : ViewModel() {

    val skillIq = repository.getUserIq()
}