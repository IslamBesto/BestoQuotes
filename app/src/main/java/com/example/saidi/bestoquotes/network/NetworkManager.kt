package com.example.saidi.bestoquotes.network

import android.os.Handler
import android.os.Looper
import com.example.saidi.bestoquotes.BuildConfig
import com.example.saidi.bestoquotes.model.BaseResponse
import com.example.saidi.bestoquotes.model.Quote
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object NetworkManager {
    private val networkService: NetworkServices

    init {
        val httpClient = OkHttpClient.Builder().addInterceptor {
            val request =
                it.request().newBuilder().addHeader(BuildConfig.API_NAME, BuildConfig.API_KEY).build()
            it.proceed(request)
        }
        val retrofit = Retrofit.Builder()
            .baseUrl("http://quotes.rest")
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

    fun getQuoteOfDay(callback: NetworkCallback<Quote>) {
        var contents: Quote? = null
        networkService.getQuoteOfDay()?.enqueue(object : Callback<BaseResponse<List<Quote>>> {
            override fun onFailure(call: Call<BaseResponse<List<Quote>>>, t: Throwable) {
                throw t
            }

            override fun onResponse(
                call: Call<BaseResponse<List<Quote>>>,
                response: Response<BaseResponse<List<Quote>>>
            ) {
                contents = response.body()?.contents?.get(0)
                notify(callback, contents)
            }

        })
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
