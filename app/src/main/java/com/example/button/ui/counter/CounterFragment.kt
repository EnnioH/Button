package com.example.button.ui.counter

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.button.R
import com.example.button.data.local.PrefsManager
import com.example.button.databinding.FragmentCounterBinding

class CounterFragment : Fragment(R.layout.fragment_counter) {

    private var _binding: FragmentCounterBinding? = null
    private val binding get() = _binding!!

    private val viewModel: CounterViewModel by viewModels {
        CounterViewModelFactory(PrefsManager(requireContext()))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentCounterBinding.bind(view)

        setupViews()
        setupClickListeners()
    }

    private fun setupViews() {
        updateCounterText()
    }

    private fun setupClickListeners() {
        binding.btnIncrement.setOnClickListener {
            viewModel.incrementCounter()
            updateCounterText()
        }
    }

    private fun updateCounterText() {
        binding.tvCounter.text = viewModel.getCounterValue().toString()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}