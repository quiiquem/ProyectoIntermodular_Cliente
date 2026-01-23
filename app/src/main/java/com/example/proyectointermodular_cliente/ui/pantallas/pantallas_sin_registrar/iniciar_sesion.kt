package com.example.proyectointermodular_cliente.ui.pantallas.pantallas_sin_registrar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectointermodular_cliente.R

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

        //[EL FORMULARIO QUE INICIA SESIÓN]

        //USERNAME
        Text( text = stringResource(R.string.Username),
            fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp)

        var username by remember {mutableStateOf("")}
        TextField(
            value = username,
            onValueChange = { username = it },
            label = { Text(text = stringResource(R.string.Username)) },
            placeholder = { Text(text = stringResource(R.string.Write_here)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        //CONTRASEÑA

        Text(text = stringResource(R.string.Password),
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp)

        var password by remember {mutableStateOf("")}
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = stringResource(R.string.Password)) },
            placeholder = { Text(text = stringResource(R.string.Write_here)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

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