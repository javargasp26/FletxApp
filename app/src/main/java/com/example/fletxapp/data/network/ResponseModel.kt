package com.example.fletxapp.data.network

import com.google.gson.annotations.SerializedName

data class ResponseModel(
    @SerializedName("success") val success: Boolean,
    @SerializedName("message") val message: String,
    @SerializedName("data") val data: List< Data>?
    )

data class Data(
    @SerializedName("id") val id: Int= 0,
    @SerializedName("driver") val driver: Driver? = Driver(0,""),
    @SerializedName("placa") val licensePlate: String ="",
    @SerializedName("status") val status: Int=0,
    @SerializedName("lonlat") val location: String ="",
    @SerializedName("front_vehicle") val imageUrl: ImageUrl,
    @SerializedName("trailer") val trailer: Trailer?,

    )

data class ImageUrl(
    @SerializedName("url") val imageUrl: String
)

data class Driver(
    @SerializedName("id") val id: Int,
    @SerializedName("full_name") val driverName: String
)

data class Trailer(
    @SerializedName("id") val id: Int,
    @SerializedName("placa") val trailerLicensePlate: String
)

