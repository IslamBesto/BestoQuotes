package com.example.saidi.bestoquotes.model

import com.google.gson.annotations.SerializedName

data class Season(
    @SerializedName("id")
    val id: Int,
    @SerializedName("startDate")
    val startDate: String,
    @SerializedName("endDate")
    val endDate: String,
    @SerializedName("currentMatchday")
    val currentMatchDay: Int
)
