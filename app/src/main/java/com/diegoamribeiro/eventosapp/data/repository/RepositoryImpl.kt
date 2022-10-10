package com.diegoamribeiro.eventosapp.data.repository

import android.util.Log
import com.diegoamribeiro.eventosapp.data.remote.datasource.RemoteDataSource
import com.diegoamribeiro.eventosapp.data.remote.model.toDomain
import com.diegoamribeiro.eventosapp.domain.EventModel
import com.diegoamribeiro.eventosapp.domain.repository.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : Repository {
    override suspend fun getAllEvents(): List<EventModel> {
        var events = emptyList<EventModel>()
        val response = remoteDataSource.getAllEvents()
        if (response.isSuccessful){
            events = response.body()!!.map {
                it.toDomain()
            }
        }
        return events
    }

    override suspend fun getEventById(id: String): EventModel {
        TODO("Not yet implemented")
    }

}