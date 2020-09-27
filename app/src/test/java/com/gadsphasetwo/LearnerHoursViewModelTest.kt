package com.gadsphasetwo

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.gadsphasetwoproject.model.User
import com.gadsphasetwoproject.model.viewModel.LearnerHoursViewModel
import com.gadsphasetwoproject.room.repository.LearnerHoursRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class LearnerHoursViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutine = TestCoroutineRule()

    @Mock
    private lateinit var repository: LearnerHoursRepository

    @Mock
    private lateinit var user: User


    private lateinit var viewModel: LearnerHoursViewModel


    @ExperimentalCoroutinesApi
    @Before
    fun setUp() = testCoroutine.runBlocking {
        MockitoAnnotations.initMocks(this)
        viewModel = LearnerHoursViewModel(repository)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun testWasUserInWithData() = testCoroutine.runBlocking {
        viewModel.learnerHours
        repository.getLearnersHours()
    }
}