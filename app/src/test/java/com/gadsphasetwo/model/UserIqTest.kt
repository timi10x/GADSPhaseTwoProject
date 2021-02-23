package com.gadsphasetwo.model

import com.gadsphasetwoproject.presentation.model.UserIq
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class UserIqTest {

    private lateinit var userIq: UserIq

    @Before
    fun setUp() {
        userIq = UserIq(
            "User 1",
            "200",
            "Nigeria",
            ""
        )
    }

    @Test
    fun test_default_values() {
        val defaultUser = UserIq(
            "User 2",
            "100",
            "Nigeria",
            ""
        )

        assertEquals(100.toString(), defaultUser.score)
        assertEquals("", defaultUser.badgeUrl)
    }

}