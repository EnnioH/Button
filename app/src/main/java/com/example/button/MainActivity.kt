package com.example.button

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.button.databinding.ActivityMainBinding
import com.example.button.ui.counter.CounterFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, CounterFragment())
            .commit()
    }
}