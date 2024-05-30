package com.adso.examen

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.adso.examen.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.parentesis.setOnClickListener { agregarParentesis() }
        binding.porcentaje.setOnClickListener { agregarDatos("%") }
        binding.division.setOnClickListener { agregarDatos("/") }
        binding.borrar.setOnClickListener { binding.DatosIngresados.text.clear() }
        binding.multiplicar.setOnClickListener { agregarDatos("*") }
        binding.restar.setOnClickListener { agregarDatos("-") }
        binding.sumar.setOnClickListener { agregarDatos("+") }
        binding.igualdad.setOnClickListener { resultado() }
        binding.nueve.setOnClickListener { agregarDatos("9") }
        binding.ocho.setOnClickListener { agregarDatos("8") }
        binding.siete.setOnClickListener { agregarDatos("7") }
        binding.seis.setOnClickListener { agregarDatos("6") }
        binding.cicno.setOnClickListener { agregarDatos("5") }
        binding.cuatro.setOnClickListener { agregarDatos("4") }
        binding.tres.setOnClickListener { agregarDatos("3") }
        binding.dos.setOnClickListener { agregarDatos("2") }
        binding.uno.setOnClickListener { agregarDatos("1") }
        binding.cero.setOnClickListener { agregarDatos("0") }
        binding.punto.setOnClickListener { agregarDatos(".") }
        binding.eliminar.setOnClickListener { eliminarTexto() }

    }

    private fun agregarParentesis() {
        val datos = binding.DatosIngresados.text.toString()

        if ('(' !in datos) {
            binding.DatosIngresados.append("(")
        } else {
            binding.DatosIngresados.append(")")
        }
    }

    private fun agregarDatos(texto: String) {
        binding.DatosIngresados.append(texto)
    }

    private fun eliminarTexto() {
        val datos = binding.DatosIngresados.text.toString()
        if (datos.isNotEmpty()) {
            binding.DatosIngresados.text.delete(datos.length - 1, datos.length)
        }
    }

    private fun resultado() {
        val mostrar = binding.DatosIngresados.text.toString()

        val datos = if (mostrar.isNotEmpty()) {
            try {
                ExpressionBuilder(mostrar).build().evaluate().toString()
            } catch (e: Exception) {
                "Error"
            }
        } else {
            "Error"
        }
        binding.DatosIngresados.setText(datos)
    }
}
