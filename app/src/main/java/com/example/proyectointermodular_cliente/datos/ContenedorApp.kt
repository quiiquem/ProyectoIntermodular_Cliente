package com.example.proyectointermodular_cliente.datos

import com.example.proyectointermodular_cliente.conexion.ProductoServicioApi
import com.example.proyectointermodular_cliente.conexion.UsuarioServicioApi
import retrofit2.Retrofit
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory

interface ContenedorApp {

    //Poner todos los repositorios como variables
    val productoRepositorio: ProductoRepositorio
    val usuarioRepositorio: UsuarioRepositorio
}

//La parte de contenedorapp (que contenga la app)

class AppContenedor : ContenedorApp{

    private val baseUrl = "http://10.0.2.2:3000"

    private val json = Json { ignoreUnknownKeys = true }

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()


//Productos

private val servicioRetrofitProducto: ProductoServicioApi by lazy {
    retrofit.create(ProductoServicioApi::class.java)
}
    override val productoRepositorio: ProductoRepositorio by lazy{
        ConexionProductoRepositorio(servicioRetrofitProducto)
    }


//Usuario
private val servicioRetrofitUsuario: UsuarioServicioApi by lazy{
    retrofit.create(UsuarioServicioApi::class.java)
}
    override val usuarioRepositorio: UsuarioRepositorio by lazy{
        ConexionUsuarioRepositorio(servicioRetrofitUsuario)
    }
}