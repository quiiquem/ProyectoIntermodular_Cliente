package com.example.proyectointermodular_cliente.datos

import com.example.proyectointermodular_cliente.conexion.CategoriasServicioApi
import com.example.proyectointermodular_cliente.conexion.ClienteServicioApi
import com.example.proyectointermodular_cliente.modelo.Categorias
import com.example.proyectointermodular_cliente.modelo.Producto

interface CategoriasRepositorio{

    suspend fun obtenerCategorias(): List<Categorias> //Lista para ver categorias
    suspend fun obtenerProductos_Categoria(): List<Producto>

}

class ConexionCategoriaRepositorio(
    private val categoriaServicioApi: CategoriasServicioApi
): CategoriasRepositorio{
    override suspend fun
}