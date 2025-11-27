package com.example.button.ui.counter

import androidx.lifecycle.ViewModel
import com.example.button.data.local.PrefsManager

class CounterViewModel(private val prefsManager: PrefsManager) : ViewModel() {

    fun getCounterValue(): Int {
        return prefsManager.getCounterValue()
    }

    fun incrementCounter() {
        val currentValue = prefsManager.getCounterValue()
        prefsManager.saveCounterValue(currentValue + 1)
    }
}