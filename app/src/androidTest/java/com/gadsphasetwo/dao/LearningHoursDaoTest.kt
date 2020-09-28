package com.gadsphasetwo.dao

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.gadsphasetwo.getValue
import com.gadsphasetwoproject.model.User
import com.gadsphasetwoproject.room.dao.LearningHoursDao
import com.gadsphasetwoproject.room.database.AppDatabase
import kotlinx.coroutines.runBlocking
import org.hamcrest.Matchers.equalTo
import org.junit.After
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LearningHoursDaoTest {
    private lateinit var database: AppDatabase
    private lateinit var learningHoursDao: LearningHoursDao

    private val userA = User(
        "User A",
        "100",
        "Nigeria",
        ""
    )

    private val userB = User(
        "User B",
        "200",
        "Nigeria",
        ""
    )

    private val userC = User(
        "User C",
        "300",
        "Nigeria",
        ""
    )

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun createDb() = runBlocking {
        val context = InstrumentationRegistry.getInstrumentation().targetContext

        database = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        learningHoursDao = database.learningHoursDao()

        learningHoursDao.insertHour(listOf(userA, userB, userC))
    }

    @After
    fun closeDb() {
        database.close()
    }

    @Test
    fun testGetUsers() {
        val userList = getValue(learningHoursDao.getAllLearnersHour())
        assertThat(userList.size, equalTo(3))

        //to ensure that the plants are sorted by name
        assertThat(userList[0], equalTo(userA))
        assertThat(userList[1], equalTo(userB))
        assertThat(userList[2], equalTo(userC))
    }

}