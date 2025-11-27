package com.example.button.data.local

import android.content.Context
import android.content.SharedPreferences

class PrefsManager(private val context: Context) {

    private val sharedPreferences: SharedPreferences by lazy {
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    fun saveCounterValue(value: Int) {
        sharedPreferences.edit().putInt(KEY_COUNTER, value).apply()
    }

    fun getCounterValue(): Int {
        return sharedPreferences.getInt(KEY_COUNTER, DEFAULT_COUNTER_VALUE)
    }

    companion object {
        private const val PREFS_NAME = "counter_prefs"
        private const val KEY_COUNTER = "counter_value"
        private const val DEFAULT_COUNTER_VALUE = 0
    }
}