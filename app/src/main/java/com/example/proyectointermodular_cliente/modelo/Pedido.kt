package com.example.proyectointermodular_cliente.modelo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Pedido(
    @SerialName("id_pedido")
    val id: Long = 0,

    @SerialName("fecha_pedido")
    val fechaPedido: String,

    @SerialName("estado")
    val estado: String,

    @SerialName("total")
    val total: Double = 0.0,

    @SerialName("cliente")
    val cliente: Cliente
)