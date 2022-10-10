package com.diegoamribeiro.eventosapp.domain.repository

import com.diegoamribeiro.eventosapp.domain.EventModel

interface Repository {
    suspend fun getAllEvents() : List<EventModel>
    suspend fun getEventById(id: String) : EventModel
}