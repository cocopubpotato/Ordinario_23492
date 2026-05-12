package com.example.ordinario_23492.API

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlin.collections.emptyList

class API {
    private val service = RetroFitHelper.getRetrofitService() //verificamos que se reciban los datos


    suspend fun getImagenAleatoria(): String { //solo estamos llamando a un dato
        val response =
            service.getjoke()
        response.body()?.value
        val msg: String


        if (response.isSuccessful) {
            msg = response.body()?.value.toString() ?: " "
        } else {
            msg = "fail"
        }


        return msg
    }


}




//preferencia
class autor(private val contexto: Context){
    companion object{
        val Context.dataStore: DataStore<Preferences>
                by preferencesDataStore(name = "configuraciones")
        val NAME = stringPreferencesKey(name = "name")
    }
    //modo lectura de la info

    val name: Flow<String> = contexto.dataStore.data.map { preferences ->
        preferences[NAME] ?: "el mismisimo Chuck Norris"
    }

    //Guardar los datos
    suspend fun guardarautor(
        nombre: String){ contexto.dataStore.edit{settings->
        settings[NAME]= nombre }
    }
}