package com.example.practicaltest01var06

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PracticalTest01Var06SecondaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_practical_test01_var06_secondary)

        val textView: TextView = findViewById(R.id.text_view)
        val okButton: Button = findViewById(R.id.Ok_button)

        val score = intent.getIntExtra("score", 0)
        textView.text = "Gained: $score"

        okButton.setOnClickListener {
            val resultIntent = Intent()
            resultIntent.putExtra("score", score)
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}