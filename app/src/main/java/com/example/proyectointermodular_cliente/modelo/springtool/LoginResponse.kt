package com.example.proyectointermodular_cliente.modelo.springtool

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

    @Serializable
    data class LoginResponse(
        @SerialName("id")
        val id: Int,

        @SerialName("username")
        val username: String,

        @SerialName("email")
        val email: String,

        @SerialName("rol")
        val rol: String
    )