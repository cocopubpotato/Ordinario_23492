package com.example.ordinario_23492

import android.provider.CalendarContract
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.ordinario_23492.API.Jokeview
import com.example.ordinario_23492.API.autor

@Composable
fun Inicio(navegador: NavHostController,vm: Jokeview){


    val context = LocalContext.current
    val preferences = autor(contexto = context)
    val corrutina= rememberCoroutineScope()
    var name = preferences.name.collectAsState("")

     Box(Modifier
         .fillMaxSize()){
         Image(painter = painterResource(R.drawable.fondo),
             modifier = Modifier.fillMaxSize(),
             contentDescription = "fondo",
             contentScale = ContentScale.FillBounds)
         Column(Modifier.padding(10.dp),verticalArrangement = Arrangement.SpaceBetween,horizontalAlignment = Alignment.CenterHorizontally) {

                Image(painter = painterResource(R.drawable.chuck),
                    modifier = Modifier
                        .clip(shape = CircleShape)
                        .height(180.dp).width(180.dp)
                        ,contentScale = ContentScale.FillBounds,
                    contentDescription = "imagen principal")
                Text("Chuck Norris",fontSize = 32.sp,textAlign = TextAlign.Center,color= Color.White)
                Text(" Marzo 10, 1940 - Marzo 19, 2026",fontSize = 22.sp,textAlign = TextAlign.Center,color= Color.White)
                Button(
                    onClick = {
                        vm.traerURLImagen()
                        navegador.navigate("Listado")}, //enviar a pantalla 2
                    Modifier
                        .padding(bottom = 8.dp)
                        ,colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF5E7C16),
                        contentColor = Color.White)
                ) {  //lista
                    Text("Comenzar",fontSize = 14.sp , textAlign = TextAlign.Center, color =Color.White )
                }


             if (name.value==" el mismisimo Chuck Norris"){
                 Text("Desarollado por el mismisimo Chuck Norris")
             }else{
                 Text("Desarollado por ${name.value }")
             }

            }

        }
    }