package com.example.saidi.bestoquotes.network

import android.telecom.Call
import com.example.saidi.bestoquotes.model.BaseResponse
import com.example.saidi.bestoquotes.model.Quote
import retrofit2.http.GET

interface NetworkServices {

    @GET("/qod.json")
    fun getQuoteOfDay(): retrofit2.Call<BaseResponse<List<Quote>>>?
}