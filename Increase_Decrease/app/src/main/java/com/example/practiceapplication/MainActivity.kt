package com.example.practiceapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        val numview = findViewById<EditText>(R.id.numview)
        val subbtn = findViewById<Button>(R.id.subBtn)
        val multibtn =findViewById<Button>(R.id.multibtn)
        val set0 =findViewById<Button>(R.id.set0)

        fun display(num:Int){
            numview.setText("$num")
        }

        fun increase(){
            display(numview.text.toString().toInt()+1)
        }
        fun decrease(){
            display(numview.text.toString().toInt()-1)
        }
        fun double(){
            display(numview.text.toString().toInt() *2)
        }
        fun zero(){
            display(numview.text.toString().toInt() *0)
        }
        subbtn.setOnClickListener{decrease() }
        button.setOnClickListener { increase() }
        multibtn.setOnClickListener { double() }
        set0.setOnClickListener { zero() }
    }
}