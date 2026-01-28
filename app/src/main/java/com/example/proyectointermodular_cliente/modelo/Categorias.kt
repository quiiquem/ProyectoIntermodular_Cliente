package com.example.proyectointermodular_cliente.modelo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Categorias(
    @SerialName(value = "id")
    val id: Int = 0,
    @SerialName(value = "desc")
    val desc: String
)