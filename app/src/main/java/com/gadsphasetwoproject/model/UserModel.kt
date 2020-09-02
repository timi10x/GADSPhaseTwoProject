package com.gadsphasetwoproject.model

import com.google.gson.annotations.SerializedName


data class UserModel(
    @SerializedName("name")
    val name: String, // Kojo Yeboah
    @SerializedName("hours")
    val hours: Int, // 99
    @SerializedName("country")
    val country: String, // Ghana
    @SerializedName("badgeUrl")
    val badgeUrl: String // https://res.cloudinary.com/mikeattara/image/upload/v1596700848/Top-learner.png
)