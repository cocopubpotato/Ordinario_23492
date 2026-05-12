package com.example.ordinario_23492.API

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroFitHelper {


        private val URL_BASE = "https://api.chucknorris.io/"
        //direccion base del api
        fun getRetrofitService(): interfase{//interfase == interfase api
            val retrofit = Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val service: interfase= retrofit.create(interfase::class.java)
            return service
        }


}