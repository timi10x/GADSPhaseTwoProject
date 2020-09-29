package com.gadsphasetwo.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.gadsphasetwo.getOrAwaitValue
import com.gadsphasetwoproject.model.viewModel.SubmitProjectViewModel
import com.gadsphasetwoproject.room.repository.SubmitProjectRepository
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain
import javax.inject.Inject


@HiltAndroidTest
class SubmitProjectViewModelTest {
    private val hiltRule = HiltAndroidRule(this)
    private val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val rule = RuleChain
        .outerRule(hiltRule)
        .around(instantTaskExecutorRule)

    private lateinit var submitProjectViewModel: SubmitProjectViewModel
    @Inject
    lateinit var submitProjectRepository: SubmitProjectRepository

    @Before
    fun setUp() {
        hiltRule.inject()
        submitProjectViewModel = SubmitProjectViewModel(submitProjectRepository)
    }

    @Test
    fun testViewModel() {
        /*submitProjectViewModel.submitProject()*/
        assertEquals(submitProjectViewModel.getLoading.getOrAwaitValue(), true)
    }

}