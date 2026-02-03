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
import androidx.compose.ui.unit.dp
import com.example.proyectointermodular_cliente.ProductoUIState
import com.example.proyectointermodular_cliente.R
import com.example.proyectointermodular_cliente.UsuarioUIState
import com.example.proyectointermodular_cliente.modelo.Favoritos
import com.example.proyectointermodular_cliente.modelo.Producto
import com.example.proyectointermodular_cliente.modelo.Usuario


@Composable
fun PantallaCatalogo(
    modifier: Modifier = Modifier,
    productoUIState: ProductoUIState,
    usuarioUIState: UsuarioUIState,
    favoritosUIState: ProductoUIState,
    obtenerProductos: () -> Unit,
    obtenerFavoritos: () -> Unit,
    insertarFavoritos: (favorito: Favoritos) -> Unit
) {

    LaunchedEffect(Unit) {
        obtenerProductos()
    }

    when (productoUIState) {
        is ProductoUIState.Cargando -> PantallaCargando(modifier = modifier.fillMaxSize())
        is ProductoUIState.Error -> PantallaError(modifier = modifier.fillMaxSize())
        is ProductoUIState.Exito -> PantallaLista(
            modifier = modifier.fillMaxSize(),
            lista = productoUIState.productos,
            lista_fav = favoritosUIState.,
            onGuardarFav = TODO()
        )
    }
}

@Composable
fun PantallaCargando(modifier: Modifier = Modifier){
    Box(modifier = Modifier.fillMaxSize())
    {
        Image(
            painter = painterResource(R.drawable.cargando),
            contentDescription = null,
            contentScale = ContentScale.Crop)
    }
}


@Composable
fun PantallaError(modifier: Modifier = Modifier){
    Box(modifier = Modifier.fillMaxSize())
    {
        Image(
            painter = painterResource(R.drawable.error),
            contentDescription = null,
            contentScale = ContentScale.Crop)
    }
}

@Composable
fun PantallaLista(modifier: Modifier = Modifier,
                  lista: List<Producto>,
                  onGuardarFav: (favorito: Favoritos) -> Unit){

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
                        text = "${producto.stock} ${stringResource(R.string.restante)}"
                    )

                    val favorito_nuevo = Favoritos(usuarioId = usuario.id, productoId = producto.id)
                    FloatingActionButton(onClick = {onGuardarFav(favorito_nuevo)}) {
                        Icon(
                            imageVector = Icons.Filled.FavoriteBorder,
                            contentDescription = (stringResource(R.string.insertar_favorito))
                        )
                    }
                    HorizontalDivider()
                }
            }
        }

    }
}