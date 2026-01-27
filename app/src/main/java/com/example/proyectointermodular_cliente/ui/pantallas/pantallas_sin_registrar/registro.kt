package com.example.proyectointermodular_cliente.ui.pantallas.pantallas_sin_registrar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectointermodular_cliente.R

@Composable
fun Registro(modifier: Modifier, onCrearCuenta: () -> Unit, onVolver: () -> Unit) {

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.background_login),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = modifier.fillMaxSize()
                .padding(bottom = 0.dp),
            verticalArrangement = Arrangement.Center
        ) {

            //Mensaje de bienvenida
            Text(
                text = stringResource(R.string.register),
                fontWeight = FontWeight.Bold,
                fontSize = 40.sp,
                textAlign = TextAlign.Center,
                lineHeight = 35.sp,
                modifier = Modifier.fillMaxWidth(),

                //Darle un estilo para que destaque más (asi no se queda en texto plano)
                style = MaterialTheme.typography.headlineLarge.copy(
                    shadow = Shadow(
                        color = MaterialTheme.colorScheme.primary.copy(alpha = 0.3f),
                        offset = Offset(4f, 4f),
                        blurRadius = 8f
                    )
                )
            )

            //USERNAME
            Text(
                text = stringResource(R.string.username),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            var username by remember { mutableStateOf("") }

            TextField(
                value = username,
                onValueChange = { username = it },
                label = { Text(text = stringResource(R.string.write_here)) },
                placeholder = { Text(text = stringResource(R.string.username)) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )

            //CONTRASEÑA
            Text(
                text = stringResource(R.string.username),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            var password by remember { mutableStateOf("") }

            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text(text = stringResource(R.string.write_here)) },
                placeholder = { Text(text = stringResource(R.string.password)) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        }
    }
}