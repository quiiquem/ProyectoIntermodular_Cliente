package com.example.proyectointermodular_cliente.modelo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class Usuario(
    @SerialName(value = "IDUsuario")
    val id: Int = 0,
    @SerialName(value = "nom_usuario")
    val nomusuario: String,
    @SerialName(value = "contrasenya_usuario") //prob haya que borrar contra por seguridad o algo, idk.
    val contrasenya: String
)