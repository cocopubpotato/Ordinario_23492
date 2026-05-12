package com.example.ordinario_23492.API

import android.util.Log
import kotlin.collections.emptyList

class API {
    private val service = RetroFitHelper.getRetrofitService() //verificamos que se reciban los datos




    suspend fun getjoke(): String { //solo estamos llamando a un dato
        val response = service.joke()  //aqui va la funcion que colocamos en la interface
        return if (response.isSuccessful){response.body()
        }else{
            null
        }
    }







}