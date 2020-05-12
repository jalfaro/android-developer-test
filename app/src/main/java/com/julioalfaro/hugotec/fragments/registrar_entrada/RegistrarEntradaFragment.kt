package com.julioalfaro.hugotec.fragments.registrar_entrada

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.julioalfaro.hugotec.R
import com.julioalfaro.hugotec.database.data.VehiculosRegistrados
import com.julioalfaro.hugotec.fragments.alta_vehiculo_oficial.AltaVehiculoOficialViewModel

class RegistrarEntradaFragment : Fragment() {
    private lateinit var button: Button;
    private lateinit var placa: EditText;
    private var registrarEntradaViewModel: RegistrarEntradaViewModel? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_registrar_entrada_layout, container, false);
        button  = root.findViewById<Button>(R.id.btn_grabar_vehiculo)
        placa = root.findViewById<EditText>(R.id.txt_placa_entrada)
        registrarEntradaViewModel = activity?.let { ViewModelProviders.of(it).get(
            RegistrarEntradaViewModel::class.java) }
        button.setOnClickListener{
            var vehiculosRegistrados:VehiculosRegistrados
            registrarEntradaViewModel?.esVehiculoRegistrado(placa.text.toString())?.observe(this, Observer { words ->
                // Update the cached copy of the words in the adapter.
                words?.let {
                    vehiculosRegistrados = it.get(0)
                }
            })
            val a = 5
        }
        return root;
    }
}