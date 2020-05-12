package com.julioalfaro.hugotec.database.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vehiculos_registrados")
data class VehiculosRegistrados(@ColumnInfo(name = "placa") val placa: String,
                                @ColumnInfo(name = "tipo_vehiculo") val tipo: TipoVehiculo) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}