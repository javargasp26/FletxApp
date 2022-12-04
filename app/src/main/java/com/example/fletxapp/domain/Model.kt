package com.example.fletxapp.domain

import com.example.fletxapp.data.network.Data
import com.example.fletxapp.data.network.Driver
import com.example.fletxapp.data.network.Trailer
import java.io.Serializable

data class Model(
    val id: Int,
    val driverName: String,
    val licensePlate: String,
    val status: Int,
    val lat: Double,
    val lng:Double,
    val imageUrl: String,
    val trailerLicensePlate: String,
    ): Serializable

fun Data.toDomain() = Model(
    id,
    getDriver(driver),
    licensePlate,
    status,
    getLat(location),
    getLng(location),
    getImageUrl(imageUrl.imageUrl),
    getTrailer(trailer)
)

fun getLng(location: String): Double {
    val newLocationValue = location.substringAfter("POINT (").substringBefore(")").substringBefore(" ")
    return newLocationValue.toDouble()
}

fun getLat(location: String): Double {
    val newLocationValue = location.substringAfter("POINT (").substringBefore(")").substringAfter(" ")
    return newLocationValue.toDouble()
}

fun getTrailer(trailer: Trailer?): String {
    var newTrailerPlateValue = "Sin trailer"
    if (trailer!=null){
        if (trailer.trailerLicensePlate != "" || trailer.trailerLicensePlate.isNotEmpty()){
            newTrailerPlateValue = trailer.trailerLicensePlate
        }
    }

    return newTrailerPlateValue
}

fun getDriver(driver: Driver?): String {
    var newDriverNameValue = "Sin conductor"
    if (driver!=null){
        if (driver.driverName != "" || driver.driverName.isNotEmpty() ){
            newDriverNameValue = driver.driverName
        }
    }
    return newDriverNameValue
}

fun getImageUrl(imageUrl: String): String {

    val newImageUrlValue = imageUrl.replace("prueba", "staging")
    return newImageUrlValue
}

fun getLocation(location: String): String {

    val newLocationValue = location.substringAfter("POINT (").substringBefore(")").replace(" ", ", ")
    return newLocationValue
    
}
