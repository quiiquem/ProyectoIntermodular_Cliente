package com.example.proyectointermodular_cliente.ui.pantallas.pantallas_registrado

import android.R.attr.text
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.proyectointermodular_cliente.ProductoUIState
import com.example.proyectointermodular_cliente.modelo.Producto

@Composable
fun PantallaCatalogo( modifier: Modifier = Modifier,
    productoUIState: ProductoUIState,
                      onProductosObtenidos: () -> Unit){

    LazyColumn(modifier = modifier.fillMaxSize()){

        item {
            when (productoUIState) {
                is ProductoUIState.Cargando -> PantallaCargando(modifier = modifier.fillMaxSize())
                is ProductoUIState.Error -> PantallaError(modifier = modifier.fillMaxSize())
                is ProductoUIState.ObtenerExito -> PantallaLista(modifier = Modifier.fillMaxSize(),
                    lista = productoUIState.producto)

                is ProductoUIState.CrearExito -> onProductosObtenidos()
            }
        }
    }
}


@Composable
fun PantallaCargando(modifier: Modifier = Modifier){
    Text("placeholder de pantalla carga")
}


@Composable
fun PantallaError(modifier: Modifier = Modifier){
    Text("placeholder de pantalla error")
}

@Composable
fun PantallaLista(modifier: Modifier = Modifier,
                  lista: List<Producto>){

    LazyColumn(modifier = modifier){
        items(lista){
            producto ->

            Box(modifier = Modifier
                .padding(8.dp))
            {
                Column(modifier = Modifier.fillMaxWidth()){
                    Text(
                        text = producto.nombre
                    )
                    Text(
                        text = "${producto.precio}€"
                    )
                    Text(
                        text = producto.categoriaID.toString()
                    )

                    HorizontalDivider()
                }
            }
        }

    }
}