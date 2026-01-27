package com.example.proyectointermodular_cliente.modelo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class Usuario(
    @SerialName(value = "usuario_id")
    val id: Int = 0,
    @SerialName(value = "nom_usuario")
    val nomusuario: String,
    @SerialName(value = "contrasenya_usuario") //prob haya que borrar contra por seguridad o algo, idk.
    val contrasenya: String,
    @SerialName(value = "email")
    val email: String
)