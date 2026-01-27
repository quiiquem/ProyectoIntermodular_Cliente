package com.example.proyectointermodular_cliente.modelo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class Producto(
    @SerialName(value = "producto_id")
    val id: Int = 0,
    @SerialName(value = "nombre")
    val nombre: String,
    @SerialName(value = "precio")
    val precio: Double,
    @SerialName(value = "stock")
    val stock: Int,
    //Para evitar problemas por ahora fecha es un string
    @SerialName(value = "fecha_ingreso")
    val fecha_ingreso: String,
    @SerialName(value = "ubicacion")
    val ubicacion: String,
    //Por ahora es un int , cuando pueda hacer claves ajenas y eso lo cambiare prob
    @SerialName(value = "categoriaId")
    val categoriaID: Int
)
