package com.example.pmdm_recu_entrega_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random
import kotlin.random.Random.Default.nextInt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val texto = findViewById<TextView>(R.id.textViewPrimeraActividad)
        val boton1 = findViewById<Button>(R.id.button1)
        val boton2 = findViewById<Button>(R.id.button2)
        val boton3 = findViewById<Button>(R.id.button3)
        val frase = "Click hecho! "


        texto.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {

                s?.let {
                    boton3.setEnabled(true)
                }
            }
        })

        boton1.setOnClickListener{
            texto.append(frase)
        }

        boton2.setOnClickListener{
            texto.append(Random.nextInt(0, 10).toString()+" ")
        }

        boton3.setOnClickListener {
            val text = texto.text
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra(MainActivity2.PARAMTEXT, text.toString())
            startActivity(intent)
        }
    }
}