package com.example.proyectointermodular_cliente.datos

import com.example.proyectointermodular_cliente.conexion.FavoritosServicioApi
import com.example.proyectointermodular_cliente.modelo.Favoritos

interface FavoritosRepositorio{
    suspend fun listarFavoritos(): List<Favoritos>
    suspend fun insertarFavorito(favoritos: Favoritos): Favoritos
    suspend fun borrarFavorito(id: String): Favoritos
}


class ConexionFavoritosRepositorio(
    private val favoritosServicioApi: FavoritosServicioApi
): FavoritosRepositorio{

    override suspend fun listarFavoritos(): List<Favoritos> =
        favoritosServicioApi.obtenerFavoritos()

    override suspend fun insertarFavorito(favoritos: Favoritos): Favoritos =
        favoritosServicioApi.insertarFavorito(favoritos)


    override suspend fun borrarFavorito(id: String): Favoritos =
        favoritosServicioApi.borrarFavorito(id)

}
