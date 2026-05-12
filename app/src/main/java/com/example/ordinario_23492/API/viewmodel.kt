package com.example.ordinario_23492.API

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kotlin.random.Random

class Jokeview: ViewModel() {
    var chiste by mutableStateOf("")
        private set

    fun traerchiste(){
        viewModelScope.launch {
            val randomId = Random.nextInt(1, 10)//1 al 9  , para sacar aleatoriamente el habitat

            chiste=  API().getjoke()
        }
    }


}