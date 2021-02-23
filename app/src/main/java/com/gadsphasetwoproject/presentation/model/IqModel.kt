package com.gadsphasetwoproject.presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class IqModel(
    var name: String? = null,
    var score: String? = null,
    var country: String? = null,
    var badgeUrl: String? = null
) : Parcelable