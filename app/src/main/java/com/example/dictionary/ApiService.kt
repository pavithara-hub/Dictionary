package com.example.dictionary

import android.telecom.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

interface ApiService {

    @GET("1FzKKi")
    fun getphoto():retrofit2.Call<List<RecyclerData>>


    companion object{
        val BASE_URL ="https://api.jsonserve.com/"
        fun create():ApiService{
            val retrofit=Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(ApiService::class.java)
        }
    }
}