package com.diegoamribeiro.eventosapp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diegoamribeiro.eventosapp.domain.EventModel
import com.diegoamribeiro.eventosapp.domain.usecase.GetAllEventsUseCase
import com.dmribeiro.pokedex_app.presentation.state.ResponseViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllEventsUseCase: GetAllEventsUseCase
) : ViewModel(){

    private val _eventsResponse = MutableLiveData<ResponseViewState<List<EventModel>>>()
    val eventsResponse: LiveData<ResponseViewState<List<EventModel>>> = _eventsResponse

    fun getAllEvents() = viewModelScope.launch(Dispatchers.IO) {
        _eventsResponse.postValue(ResponseViewState.Loading())
        getAllEventsUseCase().onSuccess {
            _eventsResponse.postValue(ResponseViewState.Success(it))
        }.onFailure {
            _eventsResponse.postValue(ResponseViewState.Error(it))
        }
    }

}