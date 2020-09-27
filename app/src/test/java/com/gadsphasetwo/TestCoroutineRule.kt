package com.gadsphasetwo

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

class TestCoroutineRule : TestRule {
    @ExperimentalCoroutinesApi
    private val dispatcher = TestCoroutineDispatcher()

    @ExperimentalCoroutinesApi
    private val scope = TestCoroutineScope(dispatcher)

    @ExperimentalCoroutinesApi
    override fun apply(base: Statement?, description: Description?) = object : Statement() {
        override fun evaluate() {
            Dispatchers.setMain(dispatcher)
            base?.evaluate()
            Dispatchers.resetMain()
            scope.cleanupTestCoroutines()
        }
    }

    @ExperimentalCoroutinesApi
    fun runBlocking(block: suspend TestCoroutineScope.() -> Unit) {
        scope.runBlockingTest { block() }
    }
}