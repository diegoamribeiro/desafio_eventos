package com.diegoamribeiro.eventosapp.data.remote.model


import com.diegoamribeiro.eventosapp.domain.EventModel
import com.google.gson.annotations.SerializedName

data class EventEntity(
    @SerializedName("date")
    val date: Long?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("latitude")
    val latitude: Double?,
    @SerializedName("longitude")
    val longitude: Double?,
    @SerializedName("people")
    val people: List<Any?>?,
    @SerializedName("price")
    val price: Double?,
    @SerializedName("title")
    val title: String?
)

fun EventEntity.toDomain(): EventModel {
    return EventModel(
        date = this.date,
        description = this.description,
        id = this.id,
        image = this.image,
        latitude = this.latitude,
        longitude = this.longitude,
        people = this.people,
        price = this.price,
        title = this.title
    )
}