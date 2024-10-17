package com.dicoding.submissone.data.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class DetailEventResponse(
    @field:SerializedName("id") val id: String,
    @field:SerializedName("name") val name: String? = null,
    @field:SerializedName("image") val image: String? = null,
    @field:SerializedName("description") val description: String? = null,
    @field:SerializedName("ownerName") val ownerName: String? = null,
    @field:SerializedName("beginTime") val beginTime: String? = null,
    @field:SerializedName("quota") val quota: Int,
    @field:SerializedName("registrant") val registrant: Int,
    @field:SerializedName("link") val link: String? = null
) : Parcelable
