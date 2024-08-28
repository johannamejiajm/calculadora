package com.example.calculadora

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editOperador1:EditText = findViewById(R.id.editOperador1)
        val editOperador2:EditText = findViewById(R.id.editOperador2)
        val operadores:Spinner = findViewById(R.id.spOperacion)
        val calcular:Button = findViewById(R.id.btnCalcular)
        val resultado:TextView = findViewById(R.id.txtResultado)
        val btnLimpiar:Button = findViewById(R.id.btnLimpiar)

        // llenar operadores
        val adapter= ArrayAdapter.createFromResource(this,R.array.ListaOperadores, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)
        operadores.adapter =adapter

        calcular.setOnClickListener{
            if (!editOperador1.text.toString().isEmpty() && !editOperador2.text.toString().isEmpty()) {
                when (operadores.selectedItem) {
                    "Sumar" -> resultado.text =
                        (editOperador1.text.toString().toDouble() + editOperador2.text.toString()
                            .toDouble()).toString()
                    "Restar" -> resultado.text =
                        (editOperador1.text.toString().toDouble() - editOperador2.text.toString()
                            .toDouble()).toString()
                    "Multiplicar" -> resultado.text =
                        (editOperador1.text.toString().toDouble() * editOperador2.text.toString()
                            .toDouble()).toString()
                    "Dividir" -> resultado.text =
                        (editOperador1.text.toString().toDouble() / editOperador2.text.toString()
                            .toDouble()).toString()
                }
            }
            else {
                AlertDialog.Builder(this).apply {
                    setTitle("Alerta")
                    setMessage("Algunos campos estan vacios")
                    setNegativeButton("Ok",null)
                }.show()
            }
        }
        btnLimpiar.setOnClickListener{
            editOperador1.text.clear()
            editOperador2.text.clear()
            resultado.text ="0"

        }
    }
}