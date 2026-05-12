package com.example.ordinario_23492.API

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

//PASO 2

//aqui es de donde sacas la ruta especifica

interface interfase {

    @GET("jokes/random")
    suspend fun getjoke(
    ): Response<datosrecibidos>


}

