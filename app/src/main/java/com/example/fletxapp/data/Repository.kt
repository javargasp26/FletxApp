package com.example.fletxapp.data

import com.example.fletxapp.data.network.ResponseService
import com.example.fletxapp.domain.Model
import com.example.fletxapp.domain.toDomain

class Repository {
    private val api = ResponseService()
    suspend fun getApiResponse(): List<Model> {
        var response = api.getApiResponse()
        return response!!.map { it.toDomain() }
    }
}