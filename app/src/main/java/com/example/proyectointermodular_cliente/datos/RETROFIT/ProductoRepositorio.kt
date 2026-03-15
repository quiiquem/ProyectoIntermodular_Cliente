package com.example.proyectointermodular_cliente.datos.RETROFIT

import com.example.proyectointermodular_cliente.conexion.ProductoServicioApi
import com.example.proyectointermodular_cliente.modelo.Producto
import com.example.proyectointermodular_cliente.modelo.springtool.APIResponse


interface ProductoRepositorio {

    suspend fun obtenerProductos(): List<Producto> //Lista para el catalogo (mostrar productos)
    suspend fun comprarProductos(): List<Producto> //Lista para ir añadiendo los que el usuario quiera comprar

    suspend fun listarProductos(): APIResponse<List<Producto>> //Mostrarlos usando la conexion a la BD (y no JSON)

}

    //Clase del repositorio
    class ConexionProductoRepositorio(
        private val productoServicioApi: ProductoServicioApi) : ProductoRepositorio {

        override suspend fun obtenerProductos(): List<Producto> =
            productoServicioApi.obtenerProductos()

        override suspend fun comprarProductos(): List<Producto> =
            productoServicioApi.comprarProductos()

        override suspend fun listarProductos(): APIResponse<List<Producto>> = productoServicioApi.listarProductos()
    }

