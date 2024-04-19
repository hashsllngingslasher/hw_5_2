package com.example.hw_5_2.ui

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.setFragmentResultListener
import com.example.hw_5_2.R
import com.example.hw_5_2.data.remote.LoveModel

class ShowResultFragment : Fragment() {
    private lateinit var tv: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_show_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv = view.findViewById(R.id.tvResult)
        setFragmentResultListener(SendDataFragment.RESULT_KEY) { _, bundle ->
            val result =
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    bundle.getSerializable(
                        SendDataFragment.MODEL_KEY,
                        LoveModel::class.java
                    )
                } else {
                    bundle.getSerializable(SendDataFragment.MODEL_KEY) as? LoveModel
                }
            tv.text = result.toString()
        }
    }
}