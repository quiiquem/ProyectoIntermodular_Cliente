package com.example.proyectointermodular_cliente

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.proyectointermodular_cliente.ui.pantallas.pantallas_registrado.MenuNavegacion
import com.example.proyectointermodular_cliente.ui.pantallas.pantallas_sin_registrar.Navegacion_Sincuenta
import com.example.proyectointermodular_cliente.ui.theme.ProyectoIntermodular

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProyectoIntermodular {
                AppPrincipal()
            }
        }
    }
}

@Composable
fun AppPrincipal() {
    var isAuthenticated by remember { mutableStateOf(false) }

    if (isAuthenticated) {
        // Sesión iniciada, osea que cambiara el menú al drawer intencion
        MenuNavegacion()
    } else {
        // No tiene cuenta todavia asi que se usa la navegación tradicional (sin apptopbar por estetica)
        Navegacion_Sincuenta(
            onLoginExitoso = {
                isAuthenticated = true //si se inicia sesion lo creara
            }
        )
    }
}