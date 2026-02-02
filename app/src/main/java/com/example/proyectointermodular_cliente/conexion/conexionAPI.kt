package com.example.proyectointermodular_cliente.conexion
import com.example.proyectointermodular_cliente.modelo.Cliente
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
    @GET("productos") //lo mismo que favorito solo que este dudo bastante que se pueda hacer asi
    suspend fun comprarProductos(): List<Producto>
}

//Favoritos

interface FavoritosServicioApi{

    @GET("favoritos")
    suspend fun obtenerFavoritos(): List<Favoritos>


   @POST("favoritos/{producto_id}")
   suspend fun insertarFavorito(
       @Body favoritos: Favoritos): Favoritos

   @DELETE("favoritos/{producto_id}")
   suspend fun borrarFavorito(
       @Body id: String): Favoritos
}


//Usuario

interface UsuarioServicioApi{

    @GET("usuario")
    suspend fun obtenerUsuario(): List<Usuario>

    @POST("usuario")
    suspend fun crearUsuario(usuario: Usuario): Usuario
}

//Cliente

interface ClienteServicioApi{

    @GET("cliente")
    suspend fun obtenerCliente(): Cliente
}

//Categorias

interface CategoriasServicioApi{

}