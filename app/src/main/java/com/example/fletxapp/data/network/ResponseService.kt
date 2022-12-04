package com.example.fletxapp.data.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ResponseService {
    private val retrofit = RetrofitHelper.getRetrofit()
    suspend fun getApiResponse(): List<Data>? {
        return withContext(Dispatchers.IO) {
            try {
                val response = retrofit.create(ApiClient::class.java).getApiResponse("Bearer ab11cb7605a030ee350d08f805057413")
                if (response.isSuccessful){
                    response.body()!!.data
                }else{
                    mutableListOf<Data>()
                }
            }catch (e :Exception){
                var empty=  mutableListOf<Data>()
                empty
            }
        }
    }
}