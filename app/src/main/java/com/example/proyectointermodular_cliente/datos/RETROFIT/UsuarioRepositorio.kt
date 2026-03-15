package com.example.proyectointermodular_cliente.datos.RETROFIT

import com.example.proyectointermodular_cliente.conexion.UsuarioServicioApi
import com.example.proyectointermodular_cliente.modelo.usuarios.Usuario
import com.example.proyectointermodular_cliente.modelo.springtool.APIResponse
import com.example.proyectointermodular_cliente.modelo.springtool.LoginRequest
import com.example.proyectointermodular_cliente.modelo.springtool.LoginResponse
import com.example.proyectointermodular_cliente.modelo.usuarios.RegistroRequest

interface UsuarioRepositorio {
    suspend fun login(username: String, password: String): APIResponse<LoginResponse>
    suspend fun registro(username: String, password: String, email: String): APIResponse<Usuario>
}

class ConexionUsuarioRepositorio(
    private val usuarioServicioApi: UsuarioServicioApi
) : UsuarioRepositorio {

    override suspend fun login(username: String, password: String): APIResponse<LoginResponse> {
        return try {
            usuarioServicioApi.login(LoginRequest(username, password))
        } catch (e: Exception) {
            APIResponse(success = false, message = e.message ?: "Error de conexión")
        }
    }

    override suspend fun registro(username: String, password: String, email: String): APIResponse<Usuario> {
        return try {
            usuarioServicioApi.registro(RegistroRequest(username, password, email))
        } catch (e: Exception) {
            APIResponse(success = false, message = e.message ?: "Error de conexión")
        }
    }
}