package com.example.proyectointermodular_cliente

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.proyectointermodular_cliente.ui.pantallas.pantallas_registrado.MenuNavegacion
import com.example.proyectointermodular_cliente.ui.pantallas.pantallas_sin_registrar.Navegacion_Sincuenta
import com.example.proyectointermodular_cliente.ui.pantallas.pantallas_sin_registrar.SeleccionarSesion
import com.example.proyectointermodular_cliente.ui.theme.ProyectoIntermodular

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProyectoIntermodular {
                var logueado by remember { mutableStateOf(false) }

                if (logueado) {
                    MenuNavegacion()
                } else {
                    Navegacion_Sincuenta(onLoginExitoso = { logueado = true })
                }
            }
        }
    }
}