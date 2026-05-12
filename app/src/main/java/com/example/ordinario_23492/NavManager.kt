package com.example.ordinario_23492

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ordinario_23492.seriesypelis.pelisviewmod

@Preview(showBackground = true)
@Composable
fun NavManager() {
    val navController = rememberNavController()
    val Pelig= remember { pelisviewmod().getpelis() }
    NavHost(navController,startDestination= "inicio"){
        composable("inicio"){
            Inicio(navController)
        }
        composable("Listado"){
            ListadoView(navController,Pelig)
        }
    }


}