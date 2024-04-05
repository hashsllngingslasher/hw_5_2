package com.example.hw_5_2.repositoty

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.hw_5_2.remote.LoveModel
import com.example.hw_5_2.remote.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    val api = RetrofitService.api

    fun getData(firstName: String, secondName: String): MutableLiveData<LoveModel> {
        val liveData = MutableLiveData<LoveModel>()
        api.getLove(firstName, secondName).enqueue(object : Callback<LoveModel> {
            override fun onResponse(p0: Call<LoveModel>, response: Response<LoveModel>) {
                if (response.isSuccessful) {
                    response.body()?.let { model ->
                        liveData.postValue(model)
                    }
                }
            }

            override fun onFailure(p0: Call<LoveModel>, p1: Throwable) {
                Log.e("fail", "onFailure: ${p1.message}")
            }
        })
        return liveData
    }
}