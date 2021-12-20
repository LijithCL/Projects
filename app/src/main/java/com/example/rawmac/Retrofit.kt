package com.example.rawmac

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object Retrofit {

    private const val BASE_URL = "https://rma.staging.kenyanut.com/api/"

    private fun getRetrofitInstance() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val userApiInstance : UserApi by lazy {
        getRetrofitInstance().create(UserApi::class.java)
    }
}