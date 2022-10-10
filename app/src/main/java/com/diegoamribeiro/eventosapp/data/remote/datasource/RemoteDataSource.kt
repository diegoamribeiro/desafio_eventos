package com.diegoamribeiro.eventosapp.data.remote.datasource

import com.diegoamribeiro.eventosapp.data.remote.model.EventEntity
import com.diegoamribeiro.eventosapp.data.remote.model.EventsResponse
import com.diegoamribeiro.eventosapp.data.remote.service.EventApiService
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val eventApiService: EventApiService
) {

    suspend fun getAllEvents(): Response<EventsResponse> {
        return eventApiService.getAllEvent()
    }

    suspend fun getEventById(id: String): Response<EventEntity> {
        return eventApiService.getEventById(id)
    }

}