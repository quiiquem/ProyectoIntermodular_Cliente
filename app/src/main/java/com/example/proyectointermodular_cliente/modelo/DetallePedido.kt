package com.example.proyectointermodular_cliente.modelo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DetallePedido(
    @SerialName("id_detalle")
    val id: Long = 0,

    @SerialName("cantidad")
    val cantidad: Int,

    @SerialName("precio_unitario")
    val precioUnitario: Double,

    @SerialName("subtotal")
    val subtotal: Double = 0.0,

    @SerialName("producto")
    val producto: Producto,

    @SerialName("pedido")
    val pedido: Pedido
)