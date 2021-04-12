package com.example.gifswithmvvm.domain.model

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("images")
    val images: Images
    )
