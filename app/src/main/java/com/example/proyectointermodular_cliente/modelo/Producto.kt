package com.example.proyectointermodular_cliente.modelo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class Producto(
    @SerialName("id_producto")
    val id: Long = 0,

    @SerialName("nombre")
    val nombre: String,

    @SerialName("precio")
    val precio: Double,

    @SerialName("imagen_url")
    val imagenUrl: String? = null,

    @SerialName("stock")
    val stock: Int = 0,

    @SerialName("fecha_alta")
    val fechaAlta: String? = null,

    @SerialName("categoria")
    val categoria: Categoria? = null,

    @SerialName("ubicacion")
    val ubicacion: Ubicaciones? = null
)