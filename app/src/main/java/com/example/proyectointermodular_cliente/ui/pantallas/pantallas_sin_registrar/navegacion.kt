package com.example.proyectointermodular_cliente.ui.pantallas.pantallas_sin_registrar

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.proyectointermodular_cliente.R
import com.example.proyectointermodular_cliente.ui.pantallas.pantallas_registrado.AppTopBar
import com.example.proyectointermodular_cliente.viewmodel.UsuarioViewModel


enum class Pantallas(@StringRes val titulo: Int) {
    Login(R.string.login),
    Register(R.string.register)

}

@Composable
fun Navegacion_Sincuenta(
    onLoginExitoso: () -> Unit,
    navController: NavHostController = rememberNavController(),
) {
    val viewModel_U: UsuarioViewModel = viewModel(factory = UsuarioViewModel.Factory)

    NavHost(
        navController = navController,
        startDestination = Pantallas.Login.name
    ) {
        composable(route = Pantallas.Login.name) {
            SeleccionarSesion(
                onIniciarSesion = { onLoginExitoso() },
                onRegistrar = { navController.navigate(Pantallas.Register.name) },
                viewModel = viewModel_U
            )
        }

        composable(route = Pantallas.Register.name) {
            Registro(
                onCrearCuenta = { navController.navigate(Pantallas.Login.name) },
                onVolver = { navController.navigate(Pantallas.Login.name) },
                viewModel = viewModel_U,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}