package com.dicoding.submissone.data.response

import com.google.gson.annotations.SerializedName

data class EventListResponse(
    @SerializedName("error") val error: Boolean,
    @SerializedName("message") val message: String,
    @SerializedName("listEvents") val events: List<EventResponse> = listOf()
)
