package com.example.proyectointermodular_cliente.modelo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Ubicaciones(
    @SerialName("id_ubicacion")
    val id: Long = 0,

    @SerialName("codigo")
    val codigo: String,

    @SerialName("descripcion")
    val descripcion: String
)