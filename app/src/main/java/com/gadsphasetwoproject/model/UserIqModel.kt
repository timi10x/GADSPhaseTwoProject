package com.gadsphasetwoproject.model

import androidx.room.Entity

@Entity(tableName = "Iq_leader_board")
data class UserIq(
    var name: String? = null,
    var score: String? = null,
    var country: String? = null,
    var badgeUrl: String? = null
)