package com.example.saidi.bestoquotes.model

import com.google.gson.annotations.SerializedName

data class Competitions(
    @SerializedName("count")
    val count: Int,
    @SerializedName("competitions")
    val compititonList: List<Competition>
)