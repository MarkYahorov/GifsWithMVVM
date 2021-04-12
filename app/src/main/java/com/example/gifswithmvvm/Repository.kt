package com.example.gifswithmvvm

import com.example.gifswithmvvm.domain.model.Original
import com.example.gifswithmvvm.domain.model.ThisData

interface Repository {

    suspend fun getGifts(gif: String): List<Original>

}