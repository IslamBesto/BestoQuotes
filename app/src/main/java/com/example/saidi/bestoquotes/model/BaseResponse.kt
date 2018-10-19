package com.example.saidi.bestoquotes.model

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    @SerializedName("success")
    val success: Success,
    @SerializedName("contents")
    val contents: T
)