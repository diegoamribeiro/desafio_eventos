package com.diegoamribeiro.eventosapp.domain.usecase

import android.os.RemoteException
import android.util.Log
import com.diegoamribeiro.eventosapp.domain.EventModel
import com.diegoamribeiro.eventosapp.domain.repository.Repository
import javax.inject.Inject

class GetAllEventsUseCase @Inject constructor(
    private val repository: Repository
) {

    suspend operator fun invoke(): Result<List<EventModel>> {
        return try {
            Log.d("***EventsUseCase", repository.getAllEvents().toString())
            Result.success(repository.getAllEvents())
        }catch (exception: RemoteException){
            Result.failure(exception)
        }
    }

}