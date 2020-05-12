package com.julioalfaro.hugotec.fragments.alta_vehiculo_residente

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.julioalfaro.hugotec.database.ParqueoDatabase
import com.julioalfaro.hugotec.database.ParqueoRepository
import com.julioalfaro.hugotec.database.data.TipoVehiculo
import com.julioalfaro.hugotec.database.data.VehiculosRegistrados
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AltaVehiculoResidenteViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: ParqueoRepository

    init {
        val estanciaDao = ParqueoDatabase.getDatabase(application, viewModelScope).estanciaDao()
        val tipoVehiculoDao = ParqueoDatabase.getDatabase(application, viewModelScope).tipoVehiculosDao()
        val vehiculosRegistradosDao = ParqueoDatabase.getDatabase(application, viewModelScope).vehiculosRegistradosDao()
        repository= ParqueoRepository(estanciaDao, tipoVehiculoDao, vehiculosRegistradosDao)
    }

    fun insertVehiculoResidente(placa: String) = viewModelScope.launch(Dispatchers.IO) {
        val vehiculo: VehiculosRegistrados = VehiculosRegistrados ( placa, TipoVehiculo(2, "Residente", true, 0.05f));
        repository.insertVehiculoRegistrado(vehiculo)
    }
}