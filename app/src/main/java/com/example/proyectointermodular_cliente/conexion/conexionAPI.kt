package com.example.proyectointermodular_cliente.conexion
import com.example.proyectointermodular_cliente.modelo.Cliente
import com.example.proyectointermodular_cliente.modelo.Favorito
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

import com.example.proyectointermodular_cliente.modelo.Producto
import com.example.proyectointermodular_cliente.modelo.usuarios.Usuario
import com.example.proyectointermodular_cliente.modelo.springtool.APIResponse
import com.example.proyectointermodular_cliente.modelo.springtool.LoginRequest
import com.example.proyectointermodular_cliente.modelo.springtool.LoginResponse
import com.example.proyectointermodular_cliente.modelo.usuarios.RegistroRequest


//Usuario

interface UsuarioServicioApi {
    @POST("auth/login")
    suspend fun login(@Body request: LoginRequest): APIResponse<LoginResponse>

    @POST("auth/registro")
    suspend fun registro(@Body usuario: RegistroRequest): APIResponse<Usuario> //Mandar un registrorequest y recibir un usuario
}

//Cliente

interface ClienteServicioApi{

    @GET("cliente")
    suspend fun obtenerCliente(): Cliente
}



//Productos

interface ProductoServicioApi{
    @GET("productos")
    suspend fun obtenerProductos(): List<Producto>
    @GET("productos") //lo mismo que favorito solo que este dudo bastante que se pueda hacer asi
    suspend fun comprarProductos(): List<Producto>

    @GET("productos")
    suspend fun listarProductos(): APIResponse<List<Producto>>
}

//Favoritos

interface FavoritosServicioApi{

    @GET("favoritos")
    suspend fun obtenerFavoritos(): List<Favorito>


    @POST("favoritos/")
    suspend fun insertarFavorito(
        @Body favoritos: Favorito): Favorito

    @DELETE("favoritos/")
    suspend fun borrarFavorito(
        @Body favoritos: Favorito): Favorito
}


//Categorias

interface CategoriasServicioApi{

}