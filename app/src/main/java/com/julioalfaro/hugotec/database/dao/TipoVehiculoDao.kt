package com.julioalfaro.hugotec.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.julioalfaro.hugotec.database.data.Estancia
import com.julioalfaro.hugotec.database.data.TipoVehiculo

@Dao
interface TipoVehiculoDao {
    @Insert
    suspend fun insert(data: TipoVehiculo)

    @Query("Select * from tipo_vehiculo")
    fun getTipoVehiculo(): LiveData<List<TipoVehiculo>>

    @Query("DELETE FROM tipo_vehiculo")
    suspend fun deleteAll()
}