package com.gadsphasetwoproject.model

data class User(
    var name: String? = null,
    var hours: String? = null,
    var country: String? = null,
    var badgeUrl: String? = null
)

data class UserIq(
    var name: String? = null,
    var score: String? = null,
    var country: String? = null,
    var badgeUrl: String? = null
)