package com.example.rawmac


import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {

    @POST("v1/login")
     fun getUsers(@Body data : Apibody): Call<Datas>
}