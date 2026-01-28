package com.example.proyectointermodular_cliente.datos

import com.example.proyectointermodular_cliente.modelo.Favoritos

interface FavoritosRepositorio{
    suspend fun listarFavoritos(): List<Favoritos>
    suspend fun insertarFavorito(favoritos: Favoritos): Favoritos
    suspend fun borrarFavorito()
}


class ConexionFavoritosRepositorio(

)