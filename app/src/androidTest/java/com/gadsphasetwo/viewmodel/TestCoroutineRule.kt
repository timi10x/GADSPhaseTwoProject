package com.gadsphasetwo.viewmodel

/*
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
}*/
