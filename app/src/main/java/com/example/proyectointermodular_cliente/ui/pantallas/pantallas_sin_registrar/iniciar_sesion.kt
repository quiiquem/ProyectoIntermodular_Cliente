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
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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

        //Mensaje de bienvenida
        Text(
            text = stringResource(R.string.mensaje_bienvenida),
            fontWeight = FontWeight.Bold,
            fontSize = 45.sp,
            textAlign = TextAlign.Center,
            lineHeight = 35.sp,
            modifier = Modifier.fillMaxWidth(),

            //Darle un estilo para que destaque más (asi no se queda en texto plano)
                    style = MaterialTheme.typography.headlineLarge.copy(
                    shadow = Shadow(
                        color = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f),
                        offset = Offset(4f, 4f),
                        blurRadius = 8f
                    )
                    )
        )

        //Eslogan o como se diga
        Text(
            text = stringResource(R.string.eslogan),
            fontWeight = FontWeight.ExtraLight,
            fontSize = 15.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(40.dp))

        //[EL FORMULARIO QUE INICIA SESIÓN]

        //USERNAME
        Text( text = stringResource(R.string.username),
            fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp)

        var username by remember {mutableStateOf("")}
        TextField(
            value = username,
            onValueChange = { username = it },
            label = { Text(text = stringResource(R.string.write_here)) },
            placeholder = { Text(text = stringResource(R.string.username)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        //CONTRASEÑA

        Text(text = stringResource(R.string.password),
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp)

        var password by remember {mutableStateOf("")}
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = stringResource(R.string.write_here)) },
            placeholder = { Text(text = stringResource(R.string.password)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        HorizontalDivider(
            modifier = Modifier.padding(vertical = 16.dp),
            color = MaterialTheme.colorScheme.outlineVariant
        )

        //"Se te ha olvidado la contraseña?"
        Button(
            modifier = modifier.width(170.dp)
                .height(80.dp),

            onClick = { /*TODO*/ }
        ){
            Text("Iniciar Sesión",
                fontSize = 20.sp,
                modifier = Modifier
                    .fillMaxWidth())
        }

    }
}