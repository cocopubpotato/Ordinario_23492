package com.example.ordinario_23492.seriesypelis

import com.example.ordinario_23492.R


class pelisviewmod {
    fun getpelis(): List<Chuckpeli>{
        val peli = mutableListOf<Chuckpeli>()
        peli.add(Chuckpeli("McQuade, el lobo solitario",img= R.drawable.mcquade))
        peli.add(Chuckpeli("Prisioneros de Guerra",img= R.drawable.prisionero))
        peli.add(Chuckpeli("Wlker, Texas Ranger",img= R.drawable.texas_ranger))
        peli.add(Chuckpeli("Logan's War: Bound by Honor",img= R.drawable.logan))
    return peli
    }
}