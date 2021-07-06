package com.example.retroplo.network

import com.example.retroplo.entity.RandomClass
import retrofit2.Call
import retrofit2.http.GET

interface EndPoint {

    //Tipo de request
    //Value es endpoint
    @GET("/api/")
    //get@GET("/api/")
    //getPerson metodo personalizado
    //Call palabra reservada de la Retrofit
    //RandomClass es el nombre del DataClas, de la llamada lo vas a guardar y convertir en RandomClass
    fun getPerson(): Call<RandomClass>
}