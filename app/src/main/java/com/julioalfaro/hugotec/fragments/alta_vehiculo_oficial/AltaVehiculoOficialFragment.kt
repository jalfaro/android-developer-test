package com.julioalfaro.hugotec.fragments.alta_vehiculo_oficial

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.julioalfaro.hugotec.R

class AltaVehiculoOficialFragment : Fragment() {
    private lateinit var button:Button
    private lateinit var txtPlaca:EditText
    private var altaVehiculoOficialViewModel: AltaVehiculoOficialViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var root = inflater.inflate(R.layout.fragment_alta_vehiculo_oficial_layout, container, false);
        altaVehiculoOficialViewModel = activity?.let { ViewModelProviders.of(it).get(AltaVehiculoOficialViewModel::class.java) }
        button = root.findViewById<Button>(R.id.btn_alta_vehiculo_oficial)
        txtPlaca = root.findViewById<EditText>(R.id.txt_placa_entrada)
        button.setOnClickListener(View.OnClickListener { view ->
            altaVehiculoOficialViewModel?.insertVehiculoOficial(txtPlaca.text.toString())
            txtPlaca.text = Editable.Factory.getInstance().newEditable("")
            Toast.makeText(activity, "Vehiculo Oficial Insertado Satisfactoriamente", Toast.LENGTH_LONG ).show()
        })
        return root
    }
}