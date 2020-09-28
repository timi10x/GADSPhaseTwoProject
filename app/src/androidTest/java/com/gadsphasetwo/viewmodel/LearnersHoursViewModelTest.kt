package com.gadsphasetwo.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.platform.app.InstrumentationRegistry
import com.gadsphasetwoproject.model.viewModel.LearnerHoursViewModel
import com.gadsphasetwoproject.room.repository.LearnerHoursRepository
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain
import javax.inject.Inject

@HiltAndroidTest
class LearnersHoursViewModelTest {

    /*@get:Rule
    val testCoroutine = TestCoroutineRule()*/

    private val hiltRule = HiltAndroidRule(this)
    private val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val rule = RuleChain
        .outerRule(hiltRule)
        .around(instantTaskExecutorRule)

    @Inject
    lateinit var repository: LearnerHoursRepository

    private lateinit var viewModel: LearnerHoursViewModel

    @Before
    fun setUp() {
        hiltRule.inject()
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        viewModel = LearnerHoursViewModel(repository)
    }


    @Test
    fun testViewModel() {
        viewModel.learnerHours
    }

}