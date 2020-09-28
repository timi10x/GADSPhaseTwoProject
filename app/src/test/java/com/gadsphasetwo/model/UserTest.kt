package com.gadsphasetwo.model

import com.gadsphasetwoproject.model.User
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class UserTest {

    private lateinit var user: User

    @Before
    fun setUp() {
        user = User(
            "User 1",
            "200",
            "Nigeria",
            ""
        )
    }

    @Test
    fun test_default_values() {
        val defaultUser = User(
            "User 2",
            "100",
            "Nigeria",
            ""
        )

        Assert.assertEquals(100.toString(), defaultUser.hours)
        Assert.assertEquals("", defaultUser.badgeUrl)
    }
}