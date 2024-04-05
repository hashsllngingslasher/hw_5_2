package com.example.hw_5_2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hw_5_2.remote.CounterModel

class CounterViewModel : ViewModel() {

    private val _counter = MutableLiveData<CounterModel>()
    val counter: LiveData<CounterModel>
        get() = _counter

    fun increment() {
        val currentCount = _counter.value?.count ?: 0
        _counter.value = CounterModel(currentCount + 1)
    }

    fun decrement() {
        val currentCount = _counter.value?.count ?: 0
        _counter.value = CounterModel(currentCount - 1)
    }
}
