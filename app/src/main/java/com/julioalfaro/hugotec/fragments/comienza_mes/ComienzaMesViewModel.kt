package com.julioalfaro.hugotec.fragments.comienza_mes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.julioalfaro.hugotec.database.ParqueoDatabase
import com.julioalfaro.hugotec.database.ParqueoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ComienzaMesViewModel(application: Application): AndroidViewModel(application) {
    private val repository: ParqueoRepository


    init {
        val estanciaDao = ParqueoDatabase.getDatabase(application, viewModelScope).estanciaDao()
        val tipoVehiculoDao = ParqueoDatabase.getDatabase(application, viewModelScope).tipoVehiculosDao()
        val vehiculosRegistradosDao = ParqueoDatabase.getDatabase(application, viewModelScope).vehiculosRegistradosDao()
        repository= ParqueoRepository(estanciaDao, tipoVehiculoDao, vehiculosRegistradosDao)
    }

    fun borraEstancia() = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteEstancia()
    }

}