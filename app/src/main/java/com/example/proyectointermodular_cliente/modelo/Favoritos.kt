package com.example.proyectointermodular_cliente.modelo

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable



@Serializable
@Entity(tableName = "favoritos")
data class Favorito(
    @PrimaryKey(autoGenerate = true)
    @SerialName("id_favorito")
    val id: Long = 0,

    @SerialName("id_cliente")
    val clienteId: Long,

    @SerialName("id_producto")
    val productoId: Long,

    @SerialName("fecha_agregado")
    val fechaAgregado: String? = null
)