package com.example.proyectointermodular_cliente.modelo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Categorias(
    @SerialName(value = "idcategorias")
    val id: Int = 0,
    @SerialName(value = "descripcion")
    val desc: String
)