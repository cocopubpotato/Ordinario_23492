package com.example.ordinario_23492.API

import android.R
import kotlinx.serialization.Serializable

@Serializable
data class datosrecibidos(
    val icon_url: String,
    val id: String,
    val value: String

)