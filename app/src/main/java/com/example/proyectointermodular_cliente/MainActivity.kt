package com.example.proyectointermodular_cliente

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import com.example.proyectointermodular_cliente.ui.pantallas.pantallas_registrado.MenuNavegacion
import com.example.proyectointermodular_cliente.ui.pantallas.pantallas_sin_registrar.SeleccionarSesion
import com.example.proyectointermodular_cliente.ui.theme.ProyectoIntermodular_ClienteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProyectoIntermodular_ClienteTheme {

                //Ya iniciado sesion (esto es placeholder hasta que login
                //tenga la navegacion indicada para ello)

                //MenuNavegacion()


                //No tiene cuenta = Se mete en esta pantalla
                SeleccionarSesion()
                }
            }
        }
    }
