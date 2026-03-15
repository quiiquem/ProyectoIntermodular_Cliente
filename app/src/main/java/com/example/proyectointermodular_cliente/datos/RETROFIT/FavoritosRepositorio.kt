package com.example.proyectointermodular_cliente.datos.RETROFIT

import com.example.proyectointermodular_cliente.conexion.FavoritosServicioApi
import com.example.proyectointermodular_cliente.modelo.Favorito

interface FavoritosRepositorio{
    suspend fun listarFavoritos(): List<Favorito>
    suspend fun insertarFavorito(favoritos: Favorito): Favorito
    suspend fun borrarFavorito(id: String): Favorito
}


