package com.julioalfaro.hugotec.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.julioalfaro.hugotec.database.converter.TipoVehiculoConverter
import com.julioalfaro.hugotec.database.dao.EstanciaDao
import com.julioalfaro.hugotec.database.dao.TipoVehiculoDao
import com.julioalfaro.hugotec.database.dao.VehiculosRegistradosDao
import com.julioalfaro.hugotec.database.data.Estancia
import com.julioalfaro.hugotec.database.data.TipoVehiculo
import com.julioalfaro.hugotec.database.data.VehiculosRegistrados
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.util.concurrent.Executors

@Database(entities = [Estancia::class, TipoVehiculo::class, VehiculosRegistrados::class], version = 3)
@TypeConverters(TipoVehiculoConverter::class)
abstract class ParqueoDatabase: RoomDatabase() {
    abstract fun estanciaDao(): EstanciaDao
    abstract fun tipoVehiculosDao() : TipoVehiculoDao
    abstract fun vehiculosRegistradosDao(): VehiculosRegistradosDao

    private class TipoVehiculoDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch {
                    var tipoVehiculoDao = database.tipoVehiculosDao()
                    tipoVehiculoDao.deleteAll()
                    var tipoVehiculo = TipoVehiculo(0, "Normal", false, 0.5f)
                    tipoVehiculoDao.insert(tipoVehiculo)
                    tipoVehiculo = TipoVehiculo(1, "Oficial", false, 0.0f)
                    tipoVehiculoDao.insert(tipoVehiculo)
                    tipoVehiculo = TipoVehiculo(2, "Residente", true, 0.05f)
                    tipoVehiculoDao.insert(tipoVehiculo)
                }
            }
        }
    }

    companion object {
        private const val DATABASE_NAME = "parqueo_db"
        @Volatile private var INSTANCE: ParqueoDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): ParqueoDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                   ParqueoDatabase::class.java,
                    DATABASE_NAME
                )
                    .addCallback(TipoVehiculoDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}