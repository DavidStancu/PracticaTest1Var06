package com.example.practicaltest01var06

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

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

    private val activityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val score = result.data?.getIntExtra("score", 0) ?: 0
            Toast.makeText(this, "Score: $score", Toast.LENGTH_SHORT).show()
        }
    }

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

        randomButton.setOnClickListener {
            if (!hold1.isChecked) {
                number1EditText.setText(possibleValues[Random.nextInt(possibleValues.size)])
            }
            if (!hold2.isChecked) {
                number2EditText.setText(possibleValues[Random.nextInt(possibleValues.size)])
            }
            if (!hold3.isChecked) {
                number3EditText.setText(possibleValues[Random.nextInt(possibleValues.size)])
            }
            val val1 = number1EditText.text.toString()
            val val2 = number2EditText.text.toString()
            val val3 = number3EditText.text.toString()

            Toast.makeText(this, "Valori: $val1, $val2, $val3", Toast.LENGTH_SHORT).show()
        }


        playButton.setOnClickListener {
            var holdCount = 0
            if (hold1.isChecked)
                holdCount++
            if (hold2.isChecked)
                holdCount++
            if (hold3.isChecked) 
                holdCount++

            val score = when (holdCount) {
                0 -> 100
                1 -> 50
                2 -> 50
                else -> 0
            }

            val intent = Intent(this, PracticalTest01Var06SecondaryActivity::class.java)
            intent.putExtra("score", score)
            activityResultLauncher.launch(intent)
        }
    }


}