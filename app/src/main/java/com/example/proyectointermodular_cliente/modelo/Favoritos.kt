package com.example.proyectointermodular_cliente.modelo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

//Un modelo puente de usuario y producto para poder hacer la lista de deseeos
@Serializable
data class Favoritos(
    //Solo pillo los ids de usuario y producto para no duplicar la info.
    @SerialName("usuario_id")
    val usuarioId: Int,
    @SerialName("producto_id")
    val productoId: Int
)