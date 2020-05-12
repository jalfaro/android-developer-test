package com.julioalfaro.hugotec.database.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tipo_vehiculo")
data class TipoVehiculo (@PrimaryKey val id: Int,
                         @ColumnInfo(name = "nombre") val nombre: String,
                         @ColumnInfo(name = "cobro_mensual") val cobroMensual: Boolean,
                         @ColumnInfo(name = "cobro_minutos_usd") val cobroMinutoUSD: Float)