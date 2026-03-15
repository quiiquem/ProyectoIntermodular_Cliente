package com.example.proyectointermodular_cliente.modelo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Cliente(
    @SerialName("id_cliente")
    val id: Long = 0,

    @SerialName("usuario_id")
    val usuarioId: Long = 0,

    @SerialName("dni")
    val dni: String?,

    @SerialName("nombre")
    val nombre: String?,

    @SerialName("apellidos")
    val apellidos: String,

    @SerialName("direccion")
    val direccion: String?,

    @SerialName("telefono")
    val telefono: String?
)