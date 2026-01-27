package com.example.proyectointermodular_cliente.conexion
import com.example.proyectointermodular_cliente.modelo.Favoritos
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
    @GET("productos")
    suspend fun obtenerProductos(): List<Producto>

    @GET("favoritos") //Esto es una idea solo ,tendre que ver si hay que ponerlo en BD o no
    suspend fun obtenerDeseados(): List<Producto>

    @GET("productos/{comprar}") //lo mismo que favorito solo que este dudo bastante que se pueda hacer asi
    suspend fun comprarProductos(): List<Producto>
}

//Favoritos

interface FavoritosServicioApi{
    @GET("favoritos/{usuario_id}")
    suspend fun obtenerFavoritos(@Path("usuarioId") usuarioId: Int): List<Producto>
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
    @GET("productos/{categoriaId}")
    suspend fun obtenerProductos_Categoria(@Path("categoriaId") categoriaId: Int): List<Producto>
}