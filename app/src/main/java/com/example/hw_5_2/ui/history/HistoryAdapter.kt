package com.example.hw_5_2.ui.history

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.hw_5_2.data.remote.LoveModel
import com.example.hw_5_2.databinding.ItemLoveBinding

class HistoryAdapter(private val listener: OnItemClickListener) : Adapter<HistoryAdapter.HistoryViewHolder>() {
    private val list = arrayListOf<LoveModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return HistoryViewHolder(
            ItemLoveBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val item = list[position]
        holder.onBind(item)
    }

    override fun getItemCount(): Int = list.size
    fun submitList(lovers: List<LoveModel>) {
        list.clear()
        list.addAll(lovers)
        notifyDataSetChanged()
    }

    inner class HistoryViewHolder(private val binding: ItemLoveBinding) : ViewHolder(binding.root) {
        fun onBind(model: LoveModel) {
            with(binding) {
                model.apply {
                    tvFirstName.text = firstName
                    tvSecondName.text = secondName
                    tvPercentage.text = percentage
                    tvResult.text = result

                    root.setOnClickListener {
                        listener.onItemClick(model)
                    }
                }
            }
        }
    }
}

