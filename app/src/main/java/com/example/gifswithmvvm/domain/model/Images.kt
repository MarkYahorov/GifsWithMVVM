package com.example.gifswithmvvm.domain.model

import com.google.gson.annotations.SerializedName

data class Images(
    @SerializedName("original")
    val original: Original
    )
