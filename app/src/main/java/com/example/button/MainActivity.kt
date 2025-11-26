package com.example.button

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.button.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var currentValue = 0
    private var isIncrementMode = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        updateDisplay()
        updateButton()

        binding.actionButton.setOnClickListener {
            if (isIncrementMode) {
                currentValue++
                if (currentValue >= 10) {
                    isIncrementMode = false
                    updateButton()
                }
            } else {
                currentValue--
                if (currentValue <= 0) {
                    isIncrementMode = true
                    updateButton()
                }
            }
            updateDisplay()
        }
    }

    private fun updateDisplay() {
        binding.counterText.text = currentValue.toString()
    }

    private fun updateButton() {
        binding.actionButton.text = if (isIncrementMode) "+" else "-"
    }
}