package com.example.proyectointermodular_cliente.modelo.usuarios

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Usuario(
    @SerialName("id_usuario")
    val id: Long = 0,

    @SerialName("username")
    val username: String,

    @SerialName("email")
    val email: String,

    @SerialName("activo")
    val activo: Boolean = true,

    @SerialName("fecha_registro")
    val fechaRegistro: String? = null

    //No se debe poner password
)