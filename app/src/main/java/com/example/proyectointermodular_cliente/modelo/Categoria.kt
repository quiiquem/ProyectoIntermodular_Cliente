package com.example.proyectointermodular_cliente.modelo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Categoria(
    @SerialName("id_categoria")
    val id: Long = 0,

    @SerialName("nombre")
    val nombre: String,

    @SerialName("descripcion")
    val descripcion: String,
)