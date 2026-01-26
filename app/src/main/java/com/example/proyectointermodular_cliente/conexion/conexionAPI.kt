package com.example.proyectointermodular_cliente.conexion
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

import com.example.proyectointermodular_cliente.modelo.Producto
import com.example.proyectointermodular_cliente.modelo.Usuario

//Productos

interface ProductoServicioApi{
    @GET("producto")
    suspend fun obtenerProductos(): List<Producto>

    @GET("producto/{favoritos}") //Esto es una idea solo ,tendre que ver si hay que ponerlo en BD o no
    suspend fun obtenerDeseados(): List<Producto>

    @GET("producto/{comprar}") //lo mismo que favorito solo que este dudo bastante que se pueda hacer asi
    suspend fun comprarProductos(): List<Producto>
}


//Usuario

interface UsuarioServicioApi{

    @GET("usuario/{id}")
    suspend fun obtenerUsuario(): Usuario
}

//Cliente

interface ClienteServicioApi{

}

//Categorias

interface CategoriasServicioApi{

}