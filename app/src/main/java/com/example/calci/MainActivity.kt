package com.example.calci

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {
    lateinit var resultView: TextView
    lateinit var inputView: TextView
    private var operator by Delegates.notNull<Char>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resultView = findViewById(R.id.result)
        inputView = findViewById(R.id.input)
    }

    @SuppressLint("SetTextI18n")
    fun clickListener(button: View) {
        when (button.id) {
            R.id.equal_to_button -> {
                val (num1, num2) = inputView.text.split(operator).map { it.toDouble() }
                when (operator) {
                    '+' -> resultView.text = (num1 + num2).toString()
                    '-' -> resultView.text = (num1 - num2).toString()
                    '*' -> resultView.text = (num1 * num2).toString()
                    '/' -> resultView.text = (num1 / num2).toString()
                    '%' -> resultView.text = (num1 % num2).toString()
                }
            }
            R.id.clear_text -> {
                inputView.text = ""
                resultView.text = "0"
            }
            R.id.backspace_button -> {
                inputView.text = inputView.text.dropLast(1)
            }
            R.id.plus_button -> {
                operator = '+'
                inputView.text = inputView.text.toString() + operator
            }
            R.id.minus_button -> {
                operator = '-'
                inputView.text = inputView.text.toString() + operator
            }
            R.id.multiply_button -> {
                operator = '*'
                inputView.text = inputView.text.toString() + operator
            }
            R.id.divide_button -> {
                operator = '/'
                inputView.text = inputView.text.toString() + operator
            }
            R.id.modulus_button -> {
                operator = '%'
                inputView.text = inputView.text.toString() + operator
            }
            else -> inputView.text = inputView.text.toString() + button.tag
        }
    }
}
