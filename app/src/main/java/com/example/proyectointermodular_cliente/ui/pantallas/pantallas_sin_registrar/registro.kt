package com.example.proyectointermodular_cliente.ui.pantallas.pantallas_sin_registrar

import androidx.compose.foundation.Image
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
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
import org.intellij.lang.annotations.JdkConstants

@Composable
fun Registro(modifier: Modifier, onCrearCuenta: (String, String, String) -> Unit, onVolver: () -> Unit) {

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.background_login),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = modifier.fillMaxSize()
                .padding(top = 110.dp),
            verticalArrangement = Arrangement.Top
        ) {

            //Mensaje de bienvenida
            Text(
                text = stringResource(R.string.crear_cuenta),
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

            Spacer(modifier = Modifier.height(20.dp))

            //USERNAME
            Text(
                text = stringResource(R.string.username),
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                modifier = Modifier.padding(start = 10.dp)
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
                fontSize = 20.sp,
                modifier = Modifier.padding(start = 10.dp)
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

            Spacer(modifier = Modifier.height(5.dp))

            //EMAIL
            Text(
                text = stringResource(R.string.email),
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                modifier = Modifier.padding(start = 10.dp)
            )
            var email by remember { mutableStateOf("") }

            TextField(
                value = email,
                onValueChange = { email = it },
                label = { Text(text = stringResource(R.string.write_here)) },
                placeholder = { Text(text = stringResource(R.string.email)) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            //BOTON PARA REGISTRARSE
            Row(modifier = Modifier.fillMaxWidth()
                , horizontalArrangement = Arrangement.Center) {
                Button(
                    modifier = Modifier
                        .width(170.dp)
                        .height(70.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF1E88E5)
                    ),
                    //Aun no pasa datos reales!!
                    onClick = { onCrearCuenta(username, password, email) }

                ) {
                    Text(
                        text = stringResource(R.string.register),
                        fontSize = 30.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp ))

            //TEXTBUTTON PARA VOLVER A LOGIN
            Row(modifier = Modifier.fillMaxWidth()
                .padding(start = 10.dp)
                , horizontalArrangement = Arrangement.Start) {
                TextButton(
                    modifier = Modifier,
                    onClick = { onVolver() }) {
                    Text(
                        text = stringResource(R.string.ya_tener_cuenta_mensaje),
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
