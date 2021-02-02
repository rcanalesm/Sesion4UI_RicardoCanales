package com.ricardocanales.s4ui_ricardocanales

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    var editTextValueNombre: String = ""
    var editTextValueApellido1: String = ""
    var editTextValueApellido2: String = ""
    var isImageShownValueH: Boolean = false
    var isImageShownValueM: Boolean = false
    var isSwitchOn: Boolean = false
    var dateSelected: String = ""



    override fun onCreate(savedInstanceState: Bundle ? ) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edit_text_Nombre.addTextChangedListener(object: TextWatcher {

            override fun afterTextChanged(s: Editable? ) {
                Log.d("tag", "Text changed")
            }

            override fun beforeTextChanged(s: CharSequence ? , start : Int, count: Int, after: Int) {
                Log.d("tag", "Text is about to change")
            }

            override fun onTextChanged(s: CharSequence ? , start : Int, before: Int, count: Int) {
                editTextValueNombre = s.toString()
                Log.d("tag", editTextValueNombre)
            }
        })

        edit_text_Apellido1.addTextChangedListener(object: TextWatcher {

            override fun afterTextChanged(s: Editable? ) {
                Log.d("tag", "Text changed")
            }

            override fun beforeTextChanged(s: CharSequence ? , start : Int, count: Int, after: Int) {
                Log.d("tag", "Text is about to change")
            }

            override fun onTextChanged(s: CharSequence ? , start : Int, before: Int, count: Int) {
                editTextValueApellido1 = s.toString()
                Log.d("tag", editTextValueApellido1)
            }
        })

        edit_text_Apellido2.addTextChangedListener(object: TextWatcher {

            override fun afterTextChanged(s: Editable? ) {
                Log.d("tag", "Text changed")
            }

            override fun beforeTextChanged(s: CharSequence ? , start : Int, count: Int, after: Int) {
                Log.d("tag", "Text is about to change")
            }

            override fun onTextChanged(s: CharSequence ? , start : Int, before: Int, count: Int) {
                editTextValueApellido2 = s.toString()
                Log.d("tag", editTextValueApellido2)
            }
        })

        image_hombre.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.hombre))
        image_mujer.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.mujer))

        switch_1.setOnCheckedChangeListener { _, isChecked ->

            if (isChecked) {
                image_hombre.visibility = View.VISIBLE
                image_mujer.visibility = View.INVISIBLE
                Log.d("tag","Imagen Hombre Visible")
            } else {
                image_mujer.visibility = View.VISIBLE
                image_hombre.visibility = View.INVISIBLE
                Log.d("tag","Imagen Mujer Visible")
            }
        }

        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        date_button.setOnClickListener {
            val dateDialog = DatePickerDialog(this, dateListener, year, month, day)
            dateDialog.show()
        }

        buttonEnviar.setOnClickListener{
            editTextValueNombre= edit_text_Nombre.text.toString()
            editTextValueApellido1 = edit_text_Apellido1.text.toString()
            editTextValueApellido2 = edit_text_Apellido2.text.toString()
            isImageShownValueH = image_hombre.isShown
            isImageShownValueM = image_mujer.isShown
            isSwitchOn = switch_1.isChecked

            val result = "Nombre: $editTextValueNombre, \n" +
                    "Primer Apellido: $editTextValueApellido1 \n" +
                    "Segundo Apellido: $editTextValueApellido2 \n" +
                    "Switch: (true: Hombre, false: Mujer) -> $isSwitchOn \n" +
                    "Fecha de nacimiento: $dateSelected"

            textViewResultado.text= result
        }
        SimplifyManager().setOwner(lifecycle)
    }
    private val dateListener = DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->

        val realMonth = monthOfYear + 1
        dateSelected = "$dayOfMonth, $realMonth, $year"
        Log.d("tag", "$dayOfMonth, $realMonth, $year")
    }

    override fun onResume() {
        super.onResume()
    }
}
