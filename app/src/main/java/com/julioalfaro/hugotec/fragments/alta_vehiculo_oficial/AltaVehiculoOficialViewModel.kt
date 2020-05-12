package com.julioalfaro.hugotec.fragments.alta_vehiculo_oficial

import android.app.Application
import android.content.Context
import androidx.lifecycle.*
import com.julioalfaro.hugotec.database.ParqueoDatabase
import com.julioalfaro.hugotec.database.ParqueoRepository
import com.julioalfaro.hugotec.database.data.TipoVehiculo
import com.julioalfaro.hugotec.database.data.VehiculosRegistrados
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class AltaVehiculoOficialViewModel(application: Application): AndroidViewModel(application) {
    private val repository: ParqueoRepository

    init {
        val estanciaDao = ParqueoDatabase.getDatabase(application, viewModelScope).estanciaDao()
        val tipoVehiculoDao = ParqueoDatabase.getDatabase(application, viewModelScope).tipoVehiculosDao()
        val vehiculosRegistradosDao = ParqueoDatabase.getDatabase(application, viewModelScope).vehiculosRegistradosDao()
        repository= ParqueoRepository(estanciaDao, tipoVehiculoDao, vehiculosRegistradosDao)
    }

    fun insertVehiculoOficial(placa: String) = viewModelScope.launch(Dispatchers.IO) {
        val vehiculo: VehiculosRegistrados = VehiculosRegistrados ( placa, TipoVehiculo(1, "Oficial", false, 0.0f));
        repository.insertVehiculoRegistrado(vehiculo)
    }
}