package com.example.act8_uf1

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val progCheckBox: CheckBox = findViewById(R.id.checkBoxProg)
        val gdCheckBox: CheckBox = findViewById(R.id.checkBoxGD)
        val ProjCheckBox: CheckBox = findViewById(R.id.checkBoxProj)
        val morningRadioButton: RadioButton = findViewById(R.id.radioButtonMorning)
        val afternoonRadioButton: RadioButton = findViewById(R.id.radioButtonAfternoon)
        val enrollButton: Button = findViewById(R.id.buttonEnroll)

        enrollButton.setOnClickListener {
            val selectedSubjects = mutableListOf<String>()
            if (progCheckBox.isChecked) selectedSubjects.add("Programació")
            if (gdCheckBox.isChecked) selectedSubjects.add("Game Design")
            if (ProjCheckBox.isChecked) selectedSubjects.add("Projecte")

            val selectedShift = when {
                morningRadioButton.isChecked -> "Matí"
                afternoonRadioButton.isChecked -> "Tarda"
                else -> "No seleccionat"
            }

            val message = "Assignatures: ${selectedSubjects.joinToString(", ")}, Torn: $selectedShift"
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        }
    }
}
