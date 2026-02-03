package com.example.proyectointermodular_cliente.ui.pantallas.pantallas_sin_registrar

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proyectointermodular_cliente.R
import com.example.proyectointermodular_cliente.UsuarioViewModel
import com.example.proyectointermodular_cliente.modelo.Usuario


enum class Pantallas(@StringRes val titulo: Int) {
    Login(R.string.login),
    Register(R.string.register)

}

@Composable
fun Navegacion_Sincuenta(
    viewModel_U: UsuarioViewModel = viewModel(factory = UsuarioViewModel.Factory),
    onLoginExitoso: () -> Unit,
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = Pantallas.Login.name
    ) {
        composable(route = Pantallas.Login.name) {
            SeleccionarSesion(
                onIniciarSesion = {
                    onLoginExitoso()
                },
                onRegistrar = {
                    navController.navigate(Pantallas.Register.name)
                }
            )
        }

        composable(route = Pantallas.Register.name) {
            Registro(
                onCrearCuenta = {
                    // Llama al ViewModel
                    viewModel_U.crearUsuario(it)

                    // Navega de vuelta al login
                    navController.navigate(Pantallas.Login.name) {
                        popUpTo(Pantallas.Login.name) { inclusive = true }
                    }
                },
                onVolver = {
                    navController.popBackStack()
                },
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}
