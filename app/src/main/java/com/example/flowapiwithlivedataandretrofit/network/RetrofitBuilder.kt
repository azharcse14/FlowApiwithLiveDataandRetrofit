package com.example.flowapiwithlivedataandretrofit.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Url.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val api:Api by lazy {
        retrofit.create(Api::class.java)
    }
}