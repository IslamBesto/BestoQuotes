package com.example.saidi.bestoquotes.model

import com.google.gson.annotations.SerializedName

data class Quote(
    @SerializedName("quote")
    val quote: String,
    @SerializedName("author")
    val author: String,
    @SerializedName("tags")
    val tags: List<String>
)