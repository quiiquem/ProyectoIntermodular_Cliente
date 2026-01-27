package com.example.proyectointermodular_cliente.modelo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Cliente(

    @SerialName(value = "IDUsuario")
    val IDUsuario: Int = 0,
    @SerialName(value = "nombre")
    val nombre: String,
    @SerialName(value = "apellido1")
    val apellido1: String,
    @SerialName(value = "apellido2")
    val apellido2: String,
    @SerialName(value = "pais")
    val pais: String,
    @SerialName(value = "ciudad")
    val ciudad: String,
    @SerialName(value = "codpostal")
    val codpostal: Int,
    @SerialName(value = "provincia")
    val provincia: String,
    @SerialName(value = "telefono")
    val telefono: Int
)
