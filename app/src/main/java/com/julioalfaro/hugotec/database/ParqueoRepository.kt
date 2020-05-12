package com.julioalfaro.hugotec.database

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.julioalfaro.hugotec.database.dao.EstanciaDao
import com.julioalfaro.hugotec.database.dao.TipoVehiculoDao
import com.julioalfaro.hugotec.database.dao.VehiculosRegistradosDao
import com.julioalfaro.hugotec.database.data.Estancia
import com.julioalfaro.hugotec.database.data.TipoVehiculo
import com.julioalfaro.hugotec.database.data.VehiculosRegistrados

class ParqueoRepository (private val estanciaDao: EstanciaDao,
                         private val tipoVehiculoDao: TipoVehiculoDao,
                         private val vehiculosRegistradosDao: VehiculosRegistradosDao
) {
    private var allEstancia: LiveData<List<Estancia>> = estanciaDao.getEstancia()
    private var allTipoVehiculo: LiveData<List<TipoVehiculo>> = tipoVehiculoDao.getTipoVehiculo()
    private var allVehiculosRegistrados: LiveData<List<VehiculosRegistrados>> = vehiculosRegistradosDao.getVehiculosRegistrados()

    fun getAllEstancia(): LiveData<List<Estancia>> {
        return allEstancia
    }

    fun getAllTipoVehiculo(): LiveData<List<TipoVehiculo>> {
        return allTipoVehiculo
    }

    fun getAllVehiculosRegistrados(): LiveData<List<VehiculosRegistrados>> {
        return allVehiculosRegistrados
    }

    fun esVehiculoRegistrado(placa: String) : LiveData<List<VehiculosRegistrados>> {
        return vehiculosRegistradosDao.esRegistrado(placa);
    }

    suspend fun insertEstancia(estancia: Estancia) {
        estanciaDao.insert(estancia)
    }

    suspend fun insertVehiculoRegistrado(vehiculo: VehiculosRegistrados) {
        vehiculosRegistradosDao.insert(vehiculo)
    }

    suspend fun deleteEstancia() {
        estanciaDao.deleteAll()
    }
}