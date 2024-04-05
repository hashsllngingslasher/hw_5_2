package com.example.hw_5_2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.hw_5_2.databinding.FragmentCounterBinding

class CounterFragment : Fragment() {
    private lateinit var binding: FragmentCounterBinding
    private val viewModel: CounterViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCounterBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.counter.observe(viewLifecycleOwner, Observer { counter ->
            binding.tvCount.text = counter.count.toString()
        })

        binding.btnInc.setOnClickListener {
            viewModel.increment()
        }

        binding.btnDec.setOnClickListener {
            viewModel.decrement()
        }
    }
}