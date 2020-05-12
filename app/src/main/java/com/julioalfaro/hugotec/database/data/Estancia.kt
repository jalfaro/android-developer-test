package com.julioalfaro.hugotec.database.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "estancia")
data class Estancia (@ColumnInfo(name = "placa") val placa: String,
                     @ColumnInfo(name = "tipo_vehiculo") val tipoVehiculo: TipoVehiculo,
                     @ColumnInfo(name = "hora_entrada") val horaEntrada: Long,
                     @ColumnInfo(name = "hora_salida") val horaSalida: Long,
                     @ColumnInfo(name = "status") val status: Int ) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
