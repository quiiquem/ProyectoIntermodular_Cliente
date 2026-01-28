package com.example.proyectointermodular_cliente.ui.pantallas.pantallas_registrado

import android.R.attr.text
import androidx.compose.foundation.Image
import androidx.compose.foundation.background

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectointermodular_cliente.R

@Composable
fun PantallaInicial() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 30.dp),
        verticalArrangement = Arrangement.Top
    ) {

        Text(
            text = stringResource(R.string.descubrir_categorias),
            modifier = Modifier.padding(start = 25.dp, bottom = 16.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp
        )

        // Lista de categorías con scroll horizontal
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                CategoriaCard(
                    nombre = "ANIME & MANGA",
                    imagenRes = R.drawable.categoria_anime // ← Header morado con Goku/Pikachu
                )
            }
            item {
                CategoriaCard(
                    nombre = "MARVEL & DC",
                    imagenRes = R.drawable.categoria_superheroes // ← Header rojo con Iron Man
                )
            }
            item {
                CategoriaCard(
                    nombre = "DC",
                    imagenRes = R.drawable.categoria_anime // ← Header azul con Batman
                )
            }
            item {
                CategoriaCard(
                    nombre = "Gaming",
                    imagenRes = R.drawable.categoria_anime // ← Header verde con Mario
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = stringResource(R.string.lista_deseos_actual),
            modifier = Modifier.padding(start = 25.dp, bottom = 16.dp),
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp
        )

        // Lista de favoritos
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(3) { index ->
                FavoritoCard(
                    nombre = "Funko ${index + 1}",
                    imagenRes = R.drawable.background_login
                )
            }
        }
    }
}

//Cards para categorias
@Composable
fun CategoriaCard(nombre: String, imagenRes: Int) {
    Box(
        modifier = Modifier
            .width(300.dp) // Más ancho para header
            .height(220.dp)
            .clip(RoundedCornerShape(12.dp))
    ) {
        // Imagen de fondo (tu header con los Funkos)
        Image(
            painter = painterResource(id = imagenRes),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Texto encima (opcional si ya tiene texto en la imagen)
        Text(
            text = nombre,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(16.dp),
            style = MaterialTheme.typography.headlineMedium.copy(
                shadow = Shadow(
                    color = Color.Black.copy(alpha = 0.7f),
                    offset = Offset(2f, 2f),
                    blurRadius = 4f
                )
            )
        )
    }
}

@Composable
fun FavoritoCard(nombre: String, imagenRes: Int) {
    Box(
        modifier = Modifier
            .width(140.dp)
            .height(180.dp)
            .clip(RoundedCornerShape(12.dp))
    ) {
        Image(
            painter = painterResource(id = imagenRes),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.3f))
        )

        Text(
            text = nombre,
            color = Color.White,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(8.dp)
        )
    }
}