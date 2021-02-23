package com.gadsphasetwoproject.presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class HoursModel(
    var name: String? = null,
    var hours: String? = null,
    var country: String? = null,
    var badgeUrl: String? = null
) : Parcelable