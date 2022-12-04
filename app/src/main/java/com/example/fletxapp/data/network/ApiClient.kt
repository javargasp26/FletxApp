package com.example.fletxapp.data.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface ApiClient {
    @GET("/people/holder_vehicles/2282.json")
    suspend fun getApiResponse(@Header("Authorization") token: String,): Response<ResponseModel>
}