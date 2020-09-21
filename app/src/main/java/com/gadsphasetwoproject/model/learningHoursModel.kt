package com.gadsphasetwoproject.model

import androidx.room.Entity


@Entity(tableName = "hours_leader_board")
data class User(
    var name: String? = null,
    var hours: String? = null,
    var country: String? = null,
    var badgeUrl: String? = null
)

