package com.example.hw_5_2.repositoty

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.hw_5_2.data.local.room.LoveDao
import com.example.hw_5_2.data.remote.LoveApi
import com.example.hw_5_2.data.remote.LoveModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Repository
@Inject constructor(private val api: LoveApi, private val dao: LoveDao) {


    fun getData(firstName: String, secondName: String): MutableLiveData<LoveModel> {
        val liveData = MutableLiveData<LoveModel>()
        api.getLove(firstName, secondName).enqueue(object : Callback<LoveModel> {
            override fun onResponse(p0: Call<LoveModel>, response: Response<LoveModel>) {
                if (response.isSuccessful) {
                    response.body()?.let { model ->
                        liveData.postValue(model)
                        dao.insert(model)
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