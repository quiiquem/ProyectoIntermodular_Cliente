package com.example.proyectointermodular_cliente.datos

import com.example.proyectointermodular_cliente.conexion.UsuarioServicioApi

interface UsuarioRepositorio{

}

class ConexionUsuarioRepositorio(
    private val usuarioServicioApi: UsuarioServicioApi)
    : UsuarioRepositorio{


    }
