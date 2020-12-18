package com.example.pmdm_recu_entrega_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {

    companion object {
        const val PARAMTEXT = "Hola"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val editText = findViewById<EditText>(R.id.editTextSecondActivity)
        val textView = findViewById<TextView>(R.id.textViewSecondActivity)
        val boton = findViewById<Button>(R.id.botonSecondActivity)

        val texto = intent.getStringExtra(PARAMTEXT)


        texto?.let{
            textView.text =texto
        }
        editText.addTextChangedListener(object: TextWatcher {  //tiene que estar dentro del onCreate, es el main de la activity.
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {

                s?.let {
                    boton.isEnabled = editText.length() == 1
                }
            }
        })

        boton.setOnClickListener{
            texto?.let{
                textView.text = division(it, editText.text.toString())
            }
        }
    }

    private fun division(texto:String, aux: String) : String{
        val num = aux.toInt()
        val lista = texto
        var salida = ""

        lista.forEach{
            salida += it
            repeat(num){
                salida += " "
            }
        }

        return salida
    }


}