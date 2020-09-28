package com.gadsphasetwo.dao

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.gadsphasetwo.getValue
import com.gadsphasetwoproject.model.UserIq
import com.gadsphasetwoproject.room.dao.SkillIqDao
import com.gadsphasetwoproject.room.database.AppDatabase
import kotlinx.coroutines.runBlocking
import org.hamcrest.Matchers
import org.junit.*

class SkillIqDaoTest {

    private lateinit var database: AppDatabase
    private lateinit var skillIqDao: SkillIqDao

    private val userA = UserIq(
        "UserIq A",
        "100",
        "Nigeria",
        ""
    )

    private val userB = UserIq(
        "UserIq B",
        "200",
        "Nigeria",
        ""
    )

    private val userC = UserIq(
        "UserIq C",
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
        skillIqDao = database.skillIqDao()
        skillIqDao.insertIq(listOf(userA, userB, userC))
    }

    @After
    fun closeDb() {
        database.close()
    }

    @Test
    fun testGetUserIqs() {
        val userList = getValue(skillIqDao.getAllLearnersIq())
        Assert.assertThat(userList.size, Matchers.equalTo(3))

        //to ensure that the plants are sorted by name
        Assert.assertThat(userList[0], Matchers.equalTo(userA))
        Assert.assertThat(userList[1], Matchers.equalTo(userB))
        Assert.assertThat(userList[2], Matchers.equalTo(userC))
    }
}