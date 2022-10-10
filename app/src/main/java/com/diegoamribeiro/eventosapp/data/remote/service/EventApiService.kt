package com.diegoamribeiro.eventosapp.data.remote.service

import com.diegoamribeiro.eventosapp.data.remote.model.EventEntity
import com.diegoamribeiro.eventosapp.data.remote.model.EventsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface EventApiService {

    @GET("events")
    suspend  fun getAllEvent(): Response<EventsResponse>

    @GET("events/{id}")
    suspend  fun getEventById(@Path("id") id: String): Response<EventEntity>

}