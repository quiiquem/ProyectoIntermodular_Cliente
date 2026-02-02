package com.example.proyectointermodular_cliente.datos

import com.example.proyectointermodular_cliente.conexion.ClienteServicioApi
import com.example.proyectointermodular_cliente.modelo.Cliente

interface ClienteRepositorio{

    suspend fun hacerseCliente(cliente : Cliente): Cliente
}


class ConexionClienteRepositorio(
    private val clienteServicioApi: ClienteServicioApi
): ClienteRepositorio {
    override suspend fun hacerseCliente(cliente: Cliente): Cliente =
        clienteServicioApi.obtenerCliente()
}