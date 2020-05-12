package com.julioalfaro.hugotec.database.dao

import androidx.lifecycle.LiveData
import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.julioalfaro.hugotec.database.data.Estancia
import com.julioalfaro.hugotec.database.data.TipoVehiculo

@Dao
interface EstanciaDao {
    @Insert
    suspend fun insert(estancia: Estancia)

    @Query("Select id, placa, tipo_vehiculo, hora_entrada, hora_salida, status from estancia")
    fun getEstancia(): LiveData<List<Estancia>>

    @Query("DELETE FROM estancia")
    suspend fun deleteAll()
}