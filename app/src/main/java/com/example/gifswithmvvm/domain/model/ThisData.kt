package com.example.gifswithmvvm.domain.model

import com.example.gifswithmvvm.domain.model.Data
import com.google.gson.annotations.SerializedName

data class ThisData(
    @SerializedName("data")
    val data: List<Data>
    )
