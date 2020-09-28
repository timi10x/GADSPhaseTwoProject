package com.gadsphasetwo.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.gadsphasetwoproject.model.viewModel.SkillIqViewModel
import com.gadsphasetwoproject.room.repository.SkillIqRepository
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain
import javax.inject.Inject


@HiltAndroidTest
class SkillIqViewModelTest {


    private val hiltRule = HiltAndroidRule(this)
    private val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val rule = RuleChain
        .outerRule(hiltRule)
        .around(instantTaskExecutorRule)

    @Inject
    lateinit var repository: SkillIqRepository

    private lateinit var viewModel: SkillIqViewModel

    @Before
    fun setUp() {
        hiltRule.inject()

        viewModel = SkillIqViewModel(repository)
    }

    @Test
    fun testViewModel() {
        viewModel.skillIq
    }
}