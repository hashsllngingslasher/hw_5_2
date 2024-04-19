package com.example.hw_5_2.ui.history

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.hw_5_2.data.remote.LoveModel
import com.example.hw_5_2.databinding.FragmentHistoryBinding
import com.example.hw_5_2.databinding.ItemDialogBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HistoryFragment : Fragment(), OnItemClickListener {
    private lateinit var binding: FragmentHistoryBinding
    private val viewModel: HistoryViewModel by viewModels()
    private val adapter = HistoryAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHistoryBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvHistory.adapter = adapter
        observe()

        binding.btnDelete.setOnClickListener {
            viewModel.deleteLoversItem(binding.etNameRequest.text.toString())
        }
    }

    private fun observe() {
        viewModel.historyLiveData.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
    }

    override fun onItemClick(item: LoveModel) {
        showAddDialog()
    }

    private fun showAddDialog() {
        val dialogBinding = ItemDialogBinding.inflate(layoutInflater)
        val dialog = AlertDialog.Builder(requireContext())
            .setView(dialogBinding.root)
            .setPositiveButton("Update") { _, _ ->
                val lover = LoveModel(
                    firstName = dialogBinding.etParam1.text.toString(),
                    secondName = dialogBinding.etParam2.text.toString(),
                    percentage = dialogBinding.etParam3.text.toString(),
                    result = dialogBinding.etParam4.text.toString()
                )
                viewModel.insertLover(lover)
            }.setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }.create()
        dialog.show()
    }
}