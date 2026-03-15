package com.example.proyectointermodular_cliente.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.proyectointermodular_cliente.Proyecto_Aplicacion
import com.example.proyectointermodular_cliente.datos.RETROFIT.UsuarioRepositorio
import com.example.proyectointermodular_cliente.modelo.springtool.LoginResponse
import kotlinx.coroutines.launch

class UsuarioViewModel(
    private val repositorio: UsuarioRepositorio
) : ViewModel() {

    var loginUiState: LoginUiState by mutableStateOf(LoginUiState.Idle)
        private set

    fun login(username: String, password: String) {
        viewModelScope.launch {
            loginUiState = LoginUiState.Cargando
            val resultado = repositorio.login(username, password)
            loginUiState = if (resultado.success && resultado.data != null) {
                usuarioActual = resultado.data
                LoginUiState.Exito(resultado.data)
            } else {
                LoginUiState.Error(resultado.message)
            }
        }
    }

    fun registro(username: String, password: String, email: String) {
        viewModelScope.launch {
            loginUiState = LoginUiState.Cargando
            val resultado = repositorio.registro(username, password, email)
            loginUiState = if (resultado.success) {
                LoginUiState.RegistroExito
            } else {
                LoginUiState.Error(resultado.message)
            }
        }
    }


    var usuarioActual: LoginResponse? by mutableStateOf(null)
        private set


    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val aplicacion = (this[APPLICATION_KEY] as Proyecto_Aplicacion)
                UsuarioViewModel(aplicacion.contenedor.usuarioRepositorio)
            }
        }
    }
}

sealed class LoginUiState {
    object Idle : LoginUiState()
    object Cargando : LoginUiState()
    object RegistroExito : LoginUiState()
    data class Exito(val usuario: LoginResponse) : LoginUiState()
    data class Error(val mensaje: String) : LoginUiState()
}


