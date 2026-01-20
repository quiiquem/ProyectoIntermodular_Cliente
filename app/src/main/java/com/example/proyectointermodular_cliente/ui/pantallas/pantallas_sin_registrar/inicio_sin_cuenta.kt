package com.example.proyectointermodular_cliente.ui.pantallas.pantallas_sin_registrar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SeleccionarSesion(modifier: Modifier = Modifier){
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){

        Text(
            "¡Bienvenido!",
            fontWeight = FontWeight.Bold
            , fontSize = 45.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        //Botones de registrar y iniciar sesión
        Button(
            modifier = modifier.width(60.dp)
                .height(80.dp),

            onClick = { /*TODO*/ }
        ){
            Text("Registrarme",
                fontSize = 30.sp)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            modifier = modifier.width(60.dp)
                .height(80.dp),

            onClick = { /*TODO*/ }
        ){
            Text("Iniciar Sesión",
                fontSize = 30.sp)
        }

    }
}