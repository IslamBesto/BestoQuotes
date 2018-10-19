package com.example.saidi.bestoquotes.model

import com.google.gson.annotations.SerializedName

data class Success(
    @SerializedName("total")
    val total: Int
)