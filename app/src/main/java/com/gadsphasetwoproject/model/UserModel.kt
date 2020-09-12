package com.gadsphasetwoproject.model

import com.google.gson.annotations.SerializedName


data class UserModel(
    @SerializedName("name")
    val name: String, // Kojo Yeboah
    @SerializedName("hours")
    val hours: String, // 99
    @SerializedName("country")
    val country: String, // Ghana
    @SerializedName("badgeUrl")
    val badgeUrl: String // https://res.cloudinary.com/mikeattara/image/upload/v1596700848/Top-learner.png
)

class User {
    var name: String? = null
    var hours: String? = null
    var country: String? = null
    var badgeUrl: String? = null

    constructor()
    constructor(name: String?, hours: String?, country: String, badgeUrl: String) {
        this.name = name
        this.hours = hours
        this.country = country
        this.badgeUrl = badgeUrl
    }
}