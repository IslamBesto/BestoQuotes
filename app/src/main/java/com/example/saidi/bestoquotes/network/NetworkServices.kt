package com.example.saidi.bestoquotes.network

import com.example.saidi.bestoquotes.model.Competition
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface NetworkServices {

    @GET("competitions/{id}")
    fun getCompetitions(@Path("id") id: Int): Call<Competition>?
}