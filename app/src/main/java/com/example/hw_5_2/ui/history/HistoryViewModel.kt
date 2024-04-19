package com.example.hw_5_2.ui.history

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hw_5_2.data.remote.LoveModel
import com.example.hw_5_2.repositoty.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    var historyLiveData = MutableLiveData<List<LoveModel>>()

    init {
        updateList()
    }

    private fun updateList() {
        val list = repository.getLocalData()
        historyLiveData.postValue(list)
    }

    fun deleteLoversItem(name: String){
        repository.delete(name)
        updateList()
    }

    fun insertLover(lover: LoveModel) {
        repository.insert(lover)
    }
}