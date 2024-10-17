package com.dicoding.submissone.data.retrofit

import com.dicoding.submissone.data.response.EventListResponse
import retrofit2.http.GET

interface ApiService {
    @GET("events?active=1")
    suspend fun getUpcomingEvents(): EventListResponse

    @GET("events?active=0")
    suspend fun getPastEvents(): EventListResponse
}
