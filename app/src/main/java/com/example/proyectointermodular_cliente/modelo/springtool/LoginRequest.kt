package com.example.proyectointermodular_cliente.modelo.springtool

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginRequest(
    @SerialName("username")
    val username: String,

    @SerialName("password")
    val password: String
)