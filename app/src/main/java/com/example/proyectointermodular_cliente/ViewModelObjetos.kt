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
import com.example.proyectointermodular_cliente.datos.ProductoRepositorio
import com.example.proyectointermodular_cliente.modelo.Producto
import com.example.proyectointermodular_cliente.modelo.Usuario
import kotlinx.coroutines.launch
import okio.IOException
import retrofit2.HttpException


//PRODUCTOS
sealed interface ProductoUIState{
    data class ObtenerExito(val producto: List<Producto>): ProductoUIState
    data class CrearExito(val producto: List<Producto>): ProductoUIState

    object Error: ProductoUIState
    object Cargando: ProductoUIState
}

class ProductoViewModel(private val productoRepositorio: ProductoRepositorio) : ViewModel() {
    var productoUIState: ProductoUIState by mutableStateOf(ProductoUIState.Cargando)
        private set


    fun obtenerProductos() {
        viewModelScope.launch {
            productoUIState = ProductoUIState.Cargando
            productoUIState = try{
                val listaProductos = productoRepositorio.obtenerProductos()
                ProductoUIState.ObtenerExito(listaProductos)
            } catch (e : IOException){
                ProductoUIState.Error
            } catch (e: HttpException){
                ProductoUIState.Error
            }
        }
    }

/*
    companion object{
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val aplicacion = (this[APPLICATION_KEY] as ProductoAplicacion)
                val productoRepositorio = aplicacion..productoRepositorio
                ProductoViewModel(productoRepositorio = productoRepositorio)
            }
        }
    }
*/}