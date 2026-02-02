package com.example.proyectointermodular_cliente.datos

import com.example.proyectointermodular_cliente.conexion.UsuarioServicioApi
import com.example.proyectointermodular_cliente.modelo.Usuario
import retrofit2.http.Path

interface UsuarioRepositorio{
    suspend fun obtenerUsuarios(): List<Usuario>
    suspend fun crearUsuario(usuario: Usuario): Usuario
}


//Clase del repositorio

class ConexionUsuarioRepositorio(

    private val usuarioServicioApi: UsuarioServicioApi
): UsuarioRepositorio{

    override suspend fun obtenerUsuarios(): List<Usuario> =
        usuarioServicioApi.obtenerUsuario()

    override suspend fun crearUsuario(usuario: Usuario): Usuario =
        usuarioServicioApi.crearUsuario(usuario)
}

