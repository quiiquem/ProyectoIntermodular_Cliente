package com.example.proyectointermodular_cliente.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.proyectointermodular_cliente.Proyecto_Aplicacion
import com.example.proyectointermodular_cliente.datos.RETROFIT.ProductoRepositorio
import com.example.proyectointermodular_cliente.modelo.Producto
import kotlinx.coroutines.launch

class ProductoViewModel(
    private val repositorio: ProductoRepositorio
) : ViewModel() {

    var productos: List<Producto> by mutableStateOf(emptyList())
        private set

    var cargando: Boolean by mutableStateOf(false)
        private set

    var error: String? by mutableStateOf(null)
        private set

    init {
        cargarProductos()
    }

    fun cargarProductos() {
        viewModelScope.launch {
            cargando = true
            try {
                val resultado = repositorio.listarProductos()
                if (resultado.success && resultado.data != null) {
                    productos = resultado.data
                } else {
                    error = resultado.message
                }
            } catch (e: Exception) {
                error = e.message
            } finally {
                cargando = false
            }
        }
    }
    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = (this[APPLICATION_KEY] as Proyecto_Aplicacion)
                ProductoViewModel(app.contenedor.productoRepositorio)
            }
        }
    }
}