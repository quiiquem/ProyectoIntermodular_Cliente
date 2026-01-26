package com.example.proyectointermodular_cliente

import com.example.proyectointermodular_cliente.modelo.Producto
import com.example.proyectointermodular_cliente.modelo.Usuario

sealed interface ProductoUIState{
    data class ObtenerProductos(val producto: List<Producto>): ProductoUIState
    data class ComprarProductos(val producto: List<Producto>): ProductoUIState
    data class ObtenerFavoritos(val producto: List<Producto>): ProductoUIState
}

fun obtenerProductos(){
    viewModelScope.launch{
    usuarioUIState.
    }
}

sealed interface UsuarioUIState{
    data class ObtenerDatos(val usuario: Usuario): UsuarioUIState
}

sealed interface ClienteUIState{

}

sealed interface CategoriaUIState{

}

