package com.example.hw_5_2.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import com.example.hw_5_2.R
import com.example.hw_5_2.databinding.FragmentFirstBinding
import com.example.hw_5_2.model.LoveModel
import com.example.hw_5_2.presenter.Presenter
import com.example.hw_5_2.ui.view.LoveView

class FirstFragment : Fragment(), LoveView {
    private lateinit var binding: FragmentFirstBinding
    private val presenter = Presenter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
    }

    private fun setListeners() {
        with(binding) {
            btnResult.setOnClickListener {
                presenter.getLoveData(etFirstName.text.toString(), etSecondName.text.toString())

                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.container, SecondFragment()).addToBackStack(null).commit()
            }
        }
    }

    override fun sendResult(loveModel: LoveModel) {
        val result = loveModel.percentage + "% " + loveModel.result
        setFragmentResult(
            "key", bundleOf(
                "data" to result
            )
        )
    }
}