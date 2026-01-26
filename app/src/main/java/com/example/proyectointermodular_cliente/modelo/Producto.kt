package com.example.proyectointermodular_cliente.modelo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.util.Date

@Serializable
data class Producto(
    @SerialName(value = "id")
    val id: Int = 0,
    @SerialName(value = "nombre")
    val nombre: String,
    @SerialName(value = "precio")
    val precio: Double,
    @SerialName(value = "stock")
    val stock: Int,
    @SerialName(value = "fecha_ingreso")
    val fecha_ingreso: Date,
    @SerialName(value = "ubicacion")
    val ubicacion: String,
    @SerialName(value = "categoria")
    val categorias: Categorias
)
