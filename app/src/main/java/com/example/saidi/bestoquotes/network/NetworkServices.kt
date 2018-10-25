package com.example.saidi.bestoquotes.network

import com.example.saidi.bestoquotes.model.Competitions
import retrofit2.Call
import retrofit2.http.GET

interface NetworkServices {

    @GET("competitions")
    fun getCompetitions(): Call<Competitions>?
}