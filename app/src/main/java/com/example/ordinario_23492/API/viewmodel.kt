package com.example.ordinario_23492.API

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.random.Random

class Jokeview: ViewModel() {
    var chiste by mutableStateOf("")
        private set
    var chisteid = mutableStateOf("")


    fun traerURLImagen(){
        val api = API()
        viewModelScope.launch{
            withContext(Dispatchers.IO){
                chiste = API().getImagenAleatoria() //llamamos a la funcion que esta en archivo api
            }
        }
    }








}