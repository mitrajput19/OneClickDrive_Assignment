package com.example.oneclickdrive_assignment

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textBox1: EditText = findViewById(R.id.textBox1)
        val textBox2: EditText = findViewById(R.id.textBox2)
        val textBox3: EditText = findViewById(R.id.textBox3)
        val calculateButton: Button = findViewById(R.id.calculateButton)
        val resultsTextView: TextView = findViewById(R.id.resultsTextView)

        calculateButton.setOnClickListener {
            val list1 = textBox1.text.toString().split(",").map { it.trim().toInt() }
            val list2 = textBox2.text.toString().split(",").map { it.trim().toInt() }
            val list3 = textBox3.text.toString().split(",").map { it.trim().toInt() }

            val intersection = list1.intersect(list2).intersect(list3).toList()
            val union = (list1 + list2 + list3).distinct().sorted()
            val highestNumber = (list1 + list2 + list3).maxOrNull()

            resultsTextView.text = "Intersection: ${intersection.joinToString(", ")}\n" +
                    "Union: ${union.joinToString(", ")}\n" +
                    "Highest Number: $highestNumber"
        }
    }
}