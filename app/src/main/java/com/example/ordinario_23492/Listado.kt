package com.example.ordinario_23492

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import coil3.compose.AsyncImage
import com.example.ordinario_23492.seriesypelis.Chuckpeli

@Composable
fun ListadoView(navegador: NavHostController,variable: List<Chuckpeli>,vm: ViewModel) {
    LaunchedEffect(Unit) {vm.t }// Carga al iniciar la vista el listado de los habitats


    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Series y Peliculas famosas")
        LazyRow(Modifier.padding(8.dp)) {
            items(variable) { cat ->            //nombre reasignado al modelo
                Card(
                    modifier = Modifier.height(270.dp)
                        .fillMaxWidth()
                        .padding(10.dp)
                        ,
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Column(modifier = Modifier.fillMaxWidth()) {
                            Image(
                                painter = painterResource(cat.img),
                                contentDescription = "imagen de categoria${cat.nombre}",
                                modifier = Modifier.height(150.dp).width(120.dp),
                                contentScale = ContentScale.FillBounds
                            )
                            Text("nombre peli", minLines = 3)


                    }
                }


            }
        }
        //con la api
        Column(Modifier.fillMaxWidth()) {
       //      AsyncImage(contentDescription = "iconito")
            Text("el chiste", fontStyle= FontStyle.Italic, )

            Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                Icon(
                    imageVector = Icons.AutoMirrored.Default.ArrowBack,
                    contentDescription = "retorno",
                    modifier = Modifier.clickable(
                        onClick = {
                            navegador.popBackStack()
                        }
                        )
                )
                Icon(
                    painter = painterResource(R.drawable.outline_save_24),
                    contentDescription = "retorno",

                )
                Icon(
                    imageVector = Icons.Filled.Refresh,
                    contentDescription = "redo",
                    modifier = Modifier.clickable(onClick = {
                        vm.traerchiste()
                    })
                )



            }

        }
    }
}