package com.example.retroplo.network

import com.example.retroplo.entity.RandomClass
import com.example.retroplo.util.Constants
import org.jetbrains.anko.doAsync
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RandomRepo() {
    private val instanciaRetrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getPersonRandomRepo():Response<RandomClass>{
        val personEndpoint:EndPoint = instanciaRetrofit.create()
        val response: Response<RandomClass> = personEndpoint.getPerson(50).execute()
        return response
    }
}



