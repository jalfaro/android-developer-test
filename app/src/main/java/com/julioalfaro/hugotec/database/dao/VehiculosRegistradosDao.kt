package com.julioalfaro.hugotec.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.julioalfaro.hugotec.database.data.Estancia
import com.julioalfaro.hugotec.database.data.VehiculosRegistrados

@Dao
interface VehiculosRegistradosDao  {
    @Insert
    suspend fun insert(vehiculo: VehiculosRegistrados)

    @Query("Select * from vehiculos_registrados")
    fun getVehiculosRegistrados(): LiveData<List<VehiculosRegistrados>>

    @Query("Select * from vehiculos_registrados where placa = :placa LIMIT 1")
    fun esRegistrado(placa: String): LiveData<List<VehiculosRegistrados>>
}