package com.gadsphasetwoproject.presentation.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Iq_leader_board")
data class UserIq(
    var name: String? = null,
    var score: String? = null,
    var country: String? = null,
    var badgeUrl: String? = null
) {
    @PrimaryKey(autoGenerate = true)
    var userIqId: Int = 0
}