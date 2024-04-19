package com.example.hw_5_2.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.hw_5_2.LoveViewModel
import com.example.hw_5_2.R
import com.example.hw_5_2.databinding.FragmentSendDataBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SendDataFragment : Fragment() {
    private lateinit var binding: FragmentSendDataBinding
    private val viewModel: LoveViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentSendDataBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
    }

    private fun setListeners() {
        with(binding) {
            btnResult.setOnClickListener {
                viewModel.getLiveData(etFirstName.text.toString(), etSecondName.text.toString())
                    .observe(viewLifecycleOwner, Observer { model ->
                        setFragmentResult(
                            RESULT_KEY, bundleOf(
                                MODEL_KEY to model
                            )
                        )
                        findNavController().navigate(R.id.showResultFragment)
                    })
            }
            btnCheck.setOnClickListener {
                findNavController().navigate(R.id.onboardingFragment)
            }
            btnHistory.setOnClickListener {
                findNavController().navigate(R.id.historyFragment)
            }
        }
    }

    companion object {
        const val RESULT_KEY = "RESULT_KEY"
        const val MODEL_KEY = "MODEL_KEY"
    }
}