package com.example.proyectointermodular_cliente

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.NavBackStackEntry
import com.example.proyectointermodular_cliente.datos.ProductoRepositorio
import com.example.proyectointermodular_cliente.datos.UsuarioRepositorio
import com.example.proyectointermodular_cliente.modelo.Producto
import com.example.proyectointermodular_cliente.modelo.Usuario
import kotlinx.coroutines.launch
import okio.IOException
import retrofit2.HttpException

//PRODUCTOS
sealed interface ProductoUIState{
    data class Exito(val productos: List<Producto>): ProductoUIState
    object Error: ProductoUIState
    object Cargando: ProductoUIState
}
class ProductoViewModel(private val productoRepositorio: ProductoRepositorio) : ViewModel() {
    var productoUIState: ProductoUIState by mutableStateOf(ProductoUIState.Cargando)
        private set

    //Funcion obtener productos
    fun obtenerProductos() {

        viewModelScope.launch {
            productoUIState = ProductoUIState.Cargando
            productoUIState = try {
                val lista = productoRepositorio.obtenerProductos()
                ProductoUIState.Exito(lista)
            } catch (e: Exception) {
                ProductoUIState.Error
            }
        }
    }

    //Factory para conectarlo a la aplicacion y poder hacer funciones
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val aplicacion = (this[APPLICATION_KEY] as Proyecto_Aplicacion)
                val productoRepositorio = aplicacion.contenedor.productoRepositorio
                ProductoViewModel(productoRepositorio = productoRepositorio)
            }
        }
    }
}

    //USUARIOS
    sealed interface UsuarioUIState {
        data class obtenerUsuarios(val usuarios_lista: List<Usuario>) :
            UsuarioUIState //Pillar lista de usuarios

        data class crearUsuario(val usuario: Usuario) : UsuarioUIState

        object Error : UsuarioUIState
        object Cargando : UsuarioUIState
    }

    class UsuarioViewModel(private val usuarioRepositorio: UsuarioRepositorio) : ViewModel() {

        var usuarioUIState: UsuarioUIState by mutableStateOf(UsuarioUIState.Cargando)
            private set

        //Insertar Usuario
        fun crearUsuario(usuario: Usuario) {
            viewModelScope.launch {
                usuarioUIState = UsuarioUIState.Cargando
                usuarioUIState = try {
                    val usuarioInsertado = usuarioRepositorio.crearUsuario(usuario)
                    UsuarioUIState.crearUsuario(usuarioInsertado)
                } catch (e: IOException) {
                    UsuarioUIState.Error
                } catch (e: HttpException) {
                    UsuarioUIState.Error
                }
            }
        }

        companion object {
            val Factory: ViewModelProvider.Factory = viewModelFactory {
                initializer {
                    val aplicacion = (this[APPLICATION_KEY] as Proyecto_Aplicacion)
                    val usuarioRepositorio = aplicacion.contenedor.usuarioRepositorio
                    UsuarioViewModel(usuarioRepositorio = usuarioRepositorio)
                }
            }
        }
    }
