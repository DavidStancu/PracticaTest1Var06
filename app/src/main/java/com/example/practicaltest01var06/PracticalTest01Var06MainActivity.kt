package com.example.practicaltest01var06

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PracticalTest01Var06MainActivity : AppCompatActivity() {
    private lateinit var number1EditText: EditText
    private lateinit var number2EditText: EditText
    private lateinit var number3EditText: EditText
    private lateinit var hold1: CheckBox
    private lateinit var hold2: CheckBox
    private lateinit var hold3: CheckBox
    private lateinit var randomButton: Button
    private lateinit var playButton: Button

    private val possibleValues = listOf("1", "2", "3", "*")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_practical_test01_var06_main)
        number1EditText = findViewById(R.id.number1_edit_text)
        number2EditText = findViewById(R.id.number2_edit_text)
        number3EditText = findViewById(R.id.number3_edit_text)
        hold1 = findViewById(R.id.hold1_check_box)
        hold2 = findViewById(R.id.hold2_check_box)
        hold3 = findViewById(R.id.hold3_check_box)
        randomButton = findViewById(R.id.random_button)
        playButton = findViewById(R.id.play_button)

    }
}