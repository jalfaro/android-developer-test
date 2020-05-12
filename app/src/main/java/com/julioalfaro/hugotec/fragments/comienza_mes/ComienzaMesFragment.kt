package com.julioalfaro.hugotec.fragments.comienza_mes

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.julioalfaro.hugotec.R
import com.julioalfaro.hugotec.fragments.alta_vehiculo_residente.AltaVehiculoResidenteViewModel

class ComienzaMesFragment : Fragment(){
    private lateinit var button: Button
    private var comienzaMesViewModel: ComienzaMesViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var root = inflater.inflate(R.layout.fragment_comienza_mes_layout, container, false);
        comienzaMesViewModel = activity?.let { ViewModelProviders.of(it).get(ComienzaMesViewModel::class.java) }
        button = root.findViewById<Button>(R.id.btn_comienza_mes)
        button.setOnClickListener{
            val builder = AlertDialog.Builder(this.requireContext())
            builder.setTitle("Comienza Mes")
            builder.setMessage("Esta seguro que quiere borrar los registros?")
            builder.setPositiveButton("Borrar"){dialog, which ->
                Toast.makeText(this.activity?.applicationContext,"Se han borrado las estancias anteriores.",Toast.LENGTH_SHORT).show()
            }
            builder.setNegativeButton("Cancelar"){dialog,which ->
                Toast.makeText(this.activity?.applicationContext,"No se aplico el comienza de mes.",Toast.LENGTH_SHORT).show()
            }
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }
        return root
    }
}