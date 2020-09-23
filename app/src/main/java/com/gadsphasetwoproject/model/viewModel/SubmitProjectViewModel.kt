package com.gadsphasetwoproject.model.viewModel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gadsphasetwoproject.room.repository.SubmitProjectRepository
import com.gadsphasetwoproject.utils.Resource
import kotlinx.coroutines.launch

class SubmitProjectViewModel @ViewModelInject constructor(
    private val repository: SubmitProjectRepository
) : ViewModel() {

    private val _isLoading: MutableLiveData<Boolean> = MutableLiveData()
    val getLoading: LiveData<Boolean>
        get() = _isLoading
    private val _isSuccessful: MutableLiveData<Boolean> = MutableLiveData()
    val getSubmission: LiveData<Boolean>
        get() = _isSuccessful

    fun submitProject(
        email: String?,
        name: String?,
        lastname: String?,
        link: String?
    ) =
        viewModelScope.launch {
            val result = repository.submitProject(
                email,
                name,
                lastname,
                link
            )
            when (
                result.status
                ) {
                Resource.Status.SUCCESS -> {
                    _isSuccessful.postValue(true)
                    _isLoading.postValue(false)
                }

                Resource.Status.ERROR -> {
                    _isSuccessful.postValue(false)
                    _isLoading.postValue(false)

                }

                Resource.Status.LOADING -> {
                    _isLoading.postValue(true)
                    _isSuccessful.postValue(false)
                }
            }
        }


}