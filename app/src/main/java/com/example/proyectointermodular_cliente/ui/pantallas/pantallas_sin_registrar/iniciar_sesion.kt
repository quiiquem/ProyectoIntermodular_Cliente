package com.example.proyectointermodular_cliente.ui.pantallas.pantallas_sin_registrar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectointermodular_cliente.R

@Composable
fun SeleccionarSesion(modifier: Modifier = Modifier) {

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.background_login),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = modifier.fillMaxSize()
                .padding(bottom = 50.dp),
            verticalArrangement = Arrangement.Center
        ) {

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

            Spacer(modifier = Modifier.height(10.dp))

            //Eslogan o como se diga
            Text(
                text = stringResource(R.string.eslogan),
                modifier = Modifier.fillMaxWidth(),
                fontWeight = FontWeight.ExtraLight,
                fontSize = 15.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(30.dp))

            //[EL FORMULARIO QUE INICIA SESIÓN]

            //USERNAME
            Text(
                text = stringResource(R.string.username),
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp
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

            Spacer(modifier = Modifier.height(5.dp))

            //CONTRASEÑA

            Text(
                text = stringResource(R.string.password),
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp
            )

            var password by remember { mutableStateOf("") }
            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text(text = stringResource(R.string.write_here)) },
                placeholder = { Text(text = stringResource(R.string.password)) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),

                //colores
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFE3F2FD), // Azul clarito suave
                    unfocusedContainerColor = Color(0xFFF5F5F5), // Gris muy claro
                    focusedIndicatorColor = Color(0xFF42A5F5), // Azul medio
                    unfocusedIndicatorColor = Color(0xFFBDBDBD)
                )
            )

            //SEPARADOR
            HorizontalDivider(
                modifier = Modifier.padding(vertical = 10.dp),
                color = MaterialTheme.colorScheme.outlineVariant
            )

            //BOTON INICIAR SESIÓN
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {

                Button(
                    modifier = modifier.width(170.dp)
                        .height(70.dp)
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF1E88E5)
                    ),
                    onClick = { /*TODO*/ }

                ) {
                    Text(
                        text = stringResource(R.string.login),
                        fontSize = 30.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }
            }


            //ROW DE "Recuperar contraseña" y "Registrarme"
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(2.dp),
                horizontalArrangement = Arrangement.Start,

            ) {

                //BOTON DE "Has olvidado tu contraseña?"
                TextButton(
                    modifier = modifier.weight(0.5f),
                    onClick = { /*TODO*/ }
                ) {
                    Text(
                        text = stringResource(R.string.olvidar_password),
                        fontSize = 15.sp,
                        fontStyle = FontStyle.Italic,
                        textDecoration = TextDecoration.Underline,
                        color = Color(0xFF1976D2),
                    )
                }

                //BOTON DE Registrarme
                TextButton(
                    modifier = modifier.weight(0.5f),
                    onClick = { /*TODO*/ }
                ) {
                    Text(
                        text = stringResource(R.string.crear_cuenta_mensaje),
                        fontSize = 15.sp,
                        fontStyle = FontStyle.Italic,
                        textDecoration = TextDecoration.Underline,
                        color = Color(0xFF1976D2),
                    )
                }

            }
        }
    }
}