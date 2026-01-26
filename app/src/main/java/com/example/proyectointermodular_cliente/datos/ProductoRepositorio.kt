package com.example.proyectointermodular_cliente.datos

import com.example.proyectointermodular_cliente.conexion.ProductoServicioApi
import com.example.proyectointermodular_cliente.modelo.Producto

interface ProductoRepositorio {

    suspend fun obtenerProductos(): List<Producto> //Lista para el catalogo (mostrar productos)
    suspend fun comprarProductos(): List<Producto> //Lista para ir añadiendo los que el usuario quiera comprar
    suspend fun obtenerDeseados(): List<Producto> //Lista para ir añadiendo los que el usuario guarde en fav.
}

//Clase del repositorio
class ConexionProductoRepositorio(
    private val productoServicioApi: ProductoServicioApi
): ProductoRepositorio{
    override suspend fun obtenerProductos(): List<Producto> = productoServicioApi.obtenerProductos()
    override suspend fun comprarProductos(): List<Producto> =  productoServicioApi.comprarProductos()
    override suspend fun obtenerDeseados(): List<Producto> = productoServicioApi.obtenerDeseados()
    }
