package com.example.retroplo.network

import com.example.retroplo.entity.RandomClass
import com.example.retroplo.util.Constants
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RandomInterceptor() {
    private val instanciaRetrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getPerson(){
        val personEndpoint:EndPoint = instanciaRetrofit.create()
        val response: Response<RandomClass> = personEndpoint.getPerson().execute()
    }
}



