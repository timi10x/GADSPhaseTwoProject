package com.gadsphasetwoproject.presentation.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "hours_leader_board")
data class User(
    var name: String? = null,
    var hours: String? = null,
    var country: String? = null,
    var badgeUrl: String? = null
) {
    @PrimaryKey(autoGenerate = true)
    var userHoursId: Int = 0
}

