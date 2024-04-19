package com.example.hw_5_2.ui.history

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hw_5_2.data.local.room.LoveDao
import com.example.hw_5_2.databinding.FragmentHistoryBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HistoryFragment : Fragment() {
    @Inject
    lateinit var dao: LoveDao
    private lateinit var binding: FragmentHistoryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHistoryBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list = dao.getAll()
        binding.tvHistory.text = list.toString()
    }
}