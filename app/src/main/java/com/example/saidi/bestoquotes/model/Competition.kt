package com.example.saidi.bestoquotes.model

import com.google.gson.annotations.SerializedName

data class Competition(
    @SerializedName("id")
    val id: Int,
    @SerializedName("area")
    val area: Area,
    @SerializedName("name")
    val name: String,
    @SerializedName("currentSeason")
    val currentSeason: Season
)