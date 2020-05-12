package com.julioalfaro.hugotec

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.navigation_view)
        val navController = findNavController(R.id.frame);
        appBarConfiguration = AppBarConfiguration(setOf(
            R.id.opt_home,
            R.id.opt_registrar_entrada,
            R.id.opt_registrar_salida,
            R.id.opt_alta_vehiculo_oficial,
            R.id.opt_alta_vehiculo_residente,
            R.id.opt_comienza_mes,
            R.id.opt_pagos_residentes), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.frame)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
