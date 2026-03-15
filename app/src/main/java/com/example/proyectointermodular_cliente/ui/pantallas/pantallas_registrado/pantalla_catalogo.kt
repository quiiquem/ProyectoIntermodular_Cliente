package com.example.proyectointermodular_cliente.ui.pantallas.pantallas_registrado

import android.R.attr.text
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.proyectointermodular_cliente.R

import com.example.proyectointermodular_cliente.modelo.Producto
import com.example.proyectointermodular_cliente.modelo.usuarios.Usuario
import com.example.proyectointermodular_cliente.viewmodel.ProductoViewModel


@Composable
fun PantallaCatalogo(viewModel: ProductoViewModel) {


    when {
        viewModel.cargando -> PantallaCargando()
        viewModel.error != null -> PantallaError()
        else -> PantallaLista(viewModel.productos)
    }
}

@Composable
fun PantallaCargando() {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(R.drawable.cargando),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun PantallaError() {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(R.drawable.error),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun PantallaLista(productos: List<Producto>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(productos) { producto ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(text = producto.nombre, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Text(text = "${producto.precio}€")
                Text(text = "${producto.categoria?.nombre}")
                Text(text = "${producto.stock} ${stringResource(R.string.restante)}")
                HorizontalDivider()
            }
        }
    }
}