package com.example.hw_5_2

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.hw_5_2.data.remote.LoveModel
import com.example.hw_5_2.repositoty.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoveViewModel
@Inject constructor(private val repository: Repository) : ViewModel() {

    fun getLiveData(firstName: String, secondName: String): LiveData<LoveModel> {
        return repository.getData(firstName, secondName)
    }
}