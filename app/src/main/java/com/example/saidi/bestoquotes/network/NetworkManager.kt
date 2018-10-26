package com.example.saidi.bestoquotes.network

import android.os.Handler
import android.os.Looper
import com.example.saidi.bestoquotes.BuildConfig
import com.example.saidi.bestoquotes.model.Competition
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object NetworkManager {
    const val PREMIER_LIGUE = 2021
    const val CHAMPIONS_LIGUE = 2001
    const val EUROPA_LIGUE = 2018
    const val LIGUE1 = 2015
    const val BUNDES_LIGUA = 2002
    const val SERIA = 2019
    const val PREMIERA_DIVISIONE = 2014

    private val networkService: NetworkServices

    init {
        val httpClient = OkHttpClient.Builder().addInterceptor {
            val request =
                it.request().newBuilder().addHeader(BuildConfig.API_NAME, BuildConfig.API_KEY).build()
            it.proceed(request)
        }
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.football-data.org/v2/")
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder()
                        .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                        .create()
                )
            )
            .client(httpClient.build())
            .build()
        networkService = retrofit.create(NetworkServices::class.java)
    }

    fun getCompetitions(callback: NetworkCallback<Competition>) {
        val request = object : Callback<Competition> {
            override fun onFailure(call: Call<Competition>, t: Throwable) {
                throw t
            }

            override fun onResponse(call: Call<Competition>, response: Response<Competition>) {
                notify(callback, response.body())
            }
        }
        networkService.getCompetitions(PREMIER_LIGUE)?.enqueue(request)
        networkService.getCompetitions(CHAMPIONS_LIGUE)?.enqueue(request)
        networkService.getCompetitions(EUROPA_LIGUE)?.enqueue(request)
        networkService.getCompetitions(LIGUE1)?.enqueue(request)
        networkService.getCompetitions(BUNDES_LIGUA)?.enqueue(request)
        networkService.getCompetitions(SERIA)?.enqueue(request)
        networkService.getCompetitions(PREMIERA_DIVISIONE)?.enqueue(request)
    }

    // notifies (on MainThread) the data received
    private fun <T> notify(callback: NetworkCallback<T>?, data: T?) {
        if (callback != null) {
            Handler(Looper.getMainLooper()).post { callback.networkCallback(data) }
        }
    }

    interface NetworkCallback<T> {

        fun networkCallback(data: T?)

    }

}
