package com.example.proyectointermodular_cliente.modelo.usuarios

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable



//RegistroRequest lo tengo para que al mandar al servidor la contraseña, la respuesta no pueda ser pillada por cualquiera q este en la red
//Pero tambien quiero iniciar como usuario asi que asi pueda pillarlo para hacer todo el tema del login

@Serializable
data class RegistroRequest(
    @SerialName("username")
    val username: String,

    @SerialName("password")
    val password: String,

    @SerialName("email")
    val email: String
)