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


        binding.division.setOnClickListener { agregarDatos("/") }
        binding.borrar.setOnClickListener { binding.DatosIngresados.text.clear() }
        binding.multiplicar.setOnClickListener { agregarDatos("*") }
        binding.restar.setOnClickListener { agregarDatos("-") }
        binding.sumar.setOnClickListener { agregarDatos("+") }
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
        binding.igualdad.setOnClickListener { resultado() }


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

                val partes = mostrar.split("[-+*/]".toRegex()).filter { it.isNotEmpty() }
                val operador = mostrar.find { it == '+' || it == '-' || it == '*' || it == '/' }

                if (partes.size == 2 && operador != null) {
                    val num1 = partes[0].toDouble()
                    val num2 = partes[1].toDouble()
                    when (operador) {
                        '+' -> sumar(num1, num2).toString()
                        '-' -> restar(num1, num2).toString()
                        '*' -> multiplicar(num1, num2).toString()
                        '/' -> dividir(num1, num2).toString()
                        else -> "Operación no reconocida"
                    }
                } else {
                    "Error: Formato inválido"
                }
            } catch (e: Exception) {
                "Error: ${e.message}"
            }
        } else {
            "Error: Entrada vacía"
        }
        binding.DatosIngresados.setText(datos)
    }

    private fun sumar(a: Double, b: Double) = a + b
    private fun restar(a: Double, b: Double) = a - b
    private fun multiplicar(a: Double, b: Double) = a * b
    private fun dividir(a: Double, b: Double): Double {
        if (b == 0.0) throw ArithmeticException("No se puede dividir por cero")
        return a / b
    }
}
