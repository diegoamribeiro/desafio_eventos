package com.diegoamribeiro.eventosapp.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class EventModel(
    val date: Long?,
    val description: String?,
    val id: String?,
    val image: String?,
    val latitude: Double?,
    val longitude: Double?,
    val people: @RawValue List<Any?>?,
    val price: Double?,
    val title: String?
) : Parcelable
