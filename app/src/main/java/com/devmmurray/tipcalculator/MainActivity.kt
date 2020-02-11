package com.devmmurray.tipcalculator

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        infoTextView.visibility = View.INVISIBLE

        calculateButton.setOnClickListener {
            val bill = billEditText.text.toString().toDouble()
            val tipPercentage = tipPercentageEditText.text.toString().toDouble() / 100
            val tipAmount = bill * tipPercentage
            val billTotal = bill + tipAmount
            infoTextView.text =
                "Tip: ${doubleToDollar(tipAmount)} \n Total: ${doubleToDollar(billTotal)}"
            infoTextView.visibility = View.VISIBLE
        }
    }

    fun doubleToDollar(number: Double): String {
        return "$" + String.format("%.2f", number)
    }
}
