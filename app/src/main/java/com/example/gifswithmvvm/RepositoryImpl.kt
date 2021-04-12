package com.example.gifswithmvvm

import com.example.gifswithmvvm.domain.model.Original
import com.example.gifswithmvvm.domain.model.ThisData

class RepositoryImpl(private val builder: RetrofitBuilder) : Repository {

    override suspend fun getGifts(gif: String): List<Original> {
        return builder.apiService.getGifts(gif).data.map {
            it.images.original
        }
    }

}