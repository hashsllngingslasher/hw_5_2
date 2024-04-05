package com.example.hw_5_2

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.hw_5_2.remote.LoveModel
import com.example.hw_5_2.repositoty.Repository

class LoveViewModel: ViewModel() {

    val repository = Repository()

    fun  getLiveData(firstName: String, secondName: String) : LiveData<LoveModel> {
        return repository.getData(firstName, secondName)
    }
}