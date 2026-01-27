package com.example.proyectointermodular_cliente

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.proyectointermodular_cliente.modelo.Producto
import com.example.proyectointermodular_cliente.modelo.Usuario

sealed interface ProductoUIState{
    data class ObtenerProductos(val producto: List<Producto>): ProductoUIState
    data class ComprarProductos(val producto: List<Producto>): ProductoUIState
    data class ObtenerFavoritos(val producto: List<Producto>): ProductoUIState
}

fun obtenerProductos(){
    {

    }
}

sealed interface UsuarioUIState{
    data class ObtenerDatos(val usuario: Usuario): UsuarioUIState
}

sealed interface ClienteUIState{

}

sealed interface CategoriaUIState{

}


//Campos usuario_obligatorios
var username by mutableStateOf("")
    private set

var password by mutableStateOf("")
    private set

var email by mutableStateOf("")
    private  set

fun Comprobar_Login(username: String, password: String){
    //TODO
}

fun Comprobar_Register(username: String, password: String, email: String){

}
