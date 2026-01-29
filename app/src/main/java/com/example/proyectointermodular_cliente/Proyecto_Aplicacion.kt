package com.example.proyectointermodular_cliente

import android.app.Application
import com.example.proyectointermodular_cliente.datos.AppContenedor
import com.example.proyectointermodular_cliente.datos.ContenedorApp

class Proyecto_Aplicacion : Application() {
    lateinit var contenedor: ContenedorApp
    override fun onCreate(){
        super.onCreate()
        contenedor = AppContenedor()
    }
}