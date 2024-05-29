package com.adso.examen

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.adso.examen.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.parentesis.setOnClickListener { AgregarCaracteres() }
    }

    private fun AgregarCaracteres() {
        val DatosIngresados = binding.DatosIngresados.text.toString().toDoubleOrNull() ?: return
        val km = DatosIngresados / 1000
        mostrarResultado("$DatosIngresados metros son $km km")
    }


    private fun mostrarResultado(mensaje: String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
    }
}
