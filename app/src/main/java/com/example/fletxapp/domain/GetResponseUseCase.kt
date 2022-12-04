package com.example.fletxapp.domain

import com.example.fletxapp.data.Repository

class GetResponseUseCase {

    private val repository = Repository()

    suspend operator fun invoke():List<Model>? = repository.getApiResponse()

}