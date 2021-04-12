package com.example.gifswithmvvm

import com.example.gifswithmvvm.domain.model.ThisData
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("search?api_key=pa7TbCo7bJw38zJwAy7Agfcl3mV6t8HH")
    suspend fun getGifts(@Query("q") request: String): ThisData

}