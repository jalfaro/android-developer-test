package com.julioalfaro.hugotec.database.converter

import androidx.room.TypeConverter
import com.julioalfaro.hugotec.database.data.TipoVehiculo

class TipoVehiculoConverter {
    @TypeConverter
    fun fromString(value: String?): TipoVehiculo? {
        val arrayData = value?.split("|")
        val info = TipoVehiculo(
            arrayData?.get(0)!!.toInt(),
            arrayData.get(1),
            arrayData.get(2).toBoolean(),
            arrayData.get(3).toFloat())
        return info
    }

    @TypeConverter
    fun TipoVehiculoToString(value: TipoVehiculo?): String? {
        return value?.id.toString() + "|" + value?.nombre + "|" + value?.cobroMensual.toString() + "|" + value?.cobroMinutoUSD.toString();
    }

}