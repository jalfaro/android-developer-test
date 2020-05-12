package com.julioalfaro.hugotec.fragments.alta_vehiculo_residente

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.julioalfaro.hugotec.R
import com.julioalfaro.hugotec.fragments.alta_vehiculo_oficial.AltaVehiculoOficialViewModel

class AltaVehiculoResidenteFragment : Fragment() {
    private lateinit var button: Button
    private lateinit var txtPlaca: EditText
    private var altaVehiculoResidenteViewModel: AltaVehiculoResidenteViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var root = inflater.inflate(R.layout.fragment_alta_vehiculo_residente_layout, container, false);
        altaVehiculoResidenteViewModel = activity?.let { ViewModelProviders.of(it).get(AltaVehiculoResidenteViewModel::class.java) }
        button = root.findViewById<Button>(R.id.btn_alta_vehiculo_residente)
        txtPlaca = root.findViewById<EditText>(R.id.txt_placa_entrada)
        button.setOnClickListener(View.OnClickListener { view ->
            altaVehiculoResidenteViewModel?.insertVehiculoResidente(txtPlaca.text.toString())
            txtPlaca.text = Editable.Factory.getInstance().newEditable("")
            Toast.makeText(activity, "Vehiculo Residente Insertado Satisfactoriamente", Toast.LENGTH_LONG ).show()
        })
        return root
    }
}