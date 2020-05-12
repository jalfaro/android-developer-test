package com.julioalfaro.hugotec.fragments.registrar_entrada

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.julioalfaro.hugotec.database.ParqueoDatabase
import com.julioalfaro.hugotec.database.ParqueoRepository
import com.julioalfaro.hugotec.database.dao.EstanciaDao
import com.julioalfaro.hugotec.database.dao.TipoVehiculoDao
import com.julioalfaro.hugotec.database.dao.VehiculosRegistradosDao
import com.julioalfaro.hugotec.database.data.VehiculosRegistrados
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegistrarEntradaViewModel (application: Application) : AndroidViewModel(application) {
    private lateinit var repository: ParqueoRepository

    init {
        var estanciaDao: EstanciaDao = ParqueoDatabase.getDatabase(application, viewModelScope).estanciaDao()
        var tipoVehiculoDao: TipoVehiculoDao = ParqueoDatabase.getDatabase(application, viewModelScope).tipoVehiculosDao()
        var vehiculosRegistradosDao: VehiculosRegistradosDao = ParqueoDatabase.getDatabase(application, viewModelScope).vehiculosRegistradosDao()
        repository = ParqueoRepository(estanciaDao, tipoVehiculoDao, vehiculosRegistradosDao)
    }

    fun esVehiculoRegistrado(placa: String): LiveData<List<VehiculosRegistrados>> {
        return repository.esVehiculoRegistrado(placa)
    }
}