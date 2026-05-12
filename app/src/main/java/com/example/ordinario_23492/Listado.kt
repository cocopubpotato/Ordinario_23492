package com.example.ordinario_23492

import android.R.attr.onClick
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
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
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
import com.example.ordinario_23492.API.Jokeview
import com.example.ordinario_23492.API.autor
import com.example.ordinario_23492.API.datosrecibidos
import com.example.ordinario_23492.seriesypelis.Chuckpeli
import kotlinx.coroutines.launch

@Composable
fun ListadoView(navegador: NavHostController,variable: List<Chuckpeli>,vm: Jokeview) {


    var nombre by remember { mutableStateOf("") }
    //info previa del usuario
    val context = LocalContext.current
    val preferences = autor(contexto = context)
    val corrutina= rememberCoroutineScope()




    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Series y Peliculas famosas")
        LazyRow(Modifier.padding(8.dp)) {
            items(variable) { cat ->            //nombre reasignado al modelo
                Card(
                    modifier = Modifier
                        .height(270.dp)
                        .fillMaxWidth()
                        .padding(10.dp)
                        ,
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Column(modifier = Modifier.fillMaxWidth()) {
                            Image(
                                painter = painterResource(cat.img),
                                contentDescription = "imagen de categoria${cat.nombre}",
                                modifier = Modifier
                                    .height(150.dp)
                                    .width(120.dp),
                                contentScale = ContentScale.FillBounds
                            )
                            Text(cat.nombre, minLines = 3,modifier= Modifier.width(120.dp))


                    }
                }


            }
        }
        //con la api
        Column(Modifier
            .fillMaxWidth()
            , horizontalAlignment =Alignment.CenterHorizontally) {
            AsyncImage(
                contentDescription = "iconito",
                model = vm.chiste.toString()
            )
            Text("''${vm.chiste}''", fontStyle = FontStyle.Italic)
            Text(vm.chiste)

//opcion B
               TextField(
                   onValueChange = { nombre = it },
                   value = nombre, label = { Text("cambia el autor") }
               )




            //botones
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
                    contentDescription = "guardar",
                    modifier= Modifier.clickable(onClick= {
                        corrutina.launch{
                            preferences.guardarautor(nombre)
                        }
                    })

                )
                Icon(
                    imageVector = Icons.Filled.Refresh,
                    contentDescription = "redo",
                    modifier = Modifier.clickable(onClick = {
                        vm.traerURLImagen()
                    })
                )



            }

        }
    }
}