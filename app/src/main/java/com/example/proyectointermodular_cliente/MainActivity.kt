package com.example.proyectointermodular_cliente

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.proyectointermodular_cliente.ui.pantallas.pantallas_registrado.MenuNavegacion
import com.example.proyectointermodular_cliente.ui.pantallas.pantallas_sin_registrar.SeleccionarSesion
import com.example.proyectointermodular_cliente.ui.theme.ProyectoIntermodular

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProyectoIntermodular {

                //Ya iniciado sesion (esto es placeholder hasta que login
                //tenga la navegacion indicada para ello)
                //MenuNavegacion()

                //No tiene cuenta = Se mete en esta pantalla
                SeleccionarSesion()
            }
        }
    }
}