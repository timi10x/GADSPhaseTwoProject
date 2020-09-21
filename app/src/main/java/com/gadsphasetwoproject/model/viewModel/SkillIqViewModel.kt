package com.gadsphasetwoproject.model.viewModel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.gadsphasetwoproject.room.repository.SkillIqRepository

class SkillIqViewModel @ViewModelInject constructor(
    private val repository: SkillIqRepository
) : ViewModel() {

    val skillIq = repository.getUserIq()
}