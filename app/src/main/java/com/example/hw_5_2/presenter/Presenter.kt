package com.example.hw_5_2.presenter

import android.util.Log
import com.example.hw_5_2.ui.view.LoveView
import com.example.hw_5_2.api.RetrofitService
import com.example.hw_5_2.model.LoveModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Presenter(private val view: LoveView) {
    private val api = RetrofitService.api

    fun getLoveData(firstName: String, secondName: String) {
        api.getLove(
            firstName = firstName,
            secondName = secondName
        ).enqueue(object : Callback<LoveModel> {
            override fun onResponse(p0: Call<LoveModel>, response: Response<LoveModel>) {
                response.body()?.let { model ->
                    view.sendResult(model)
                }
            }

            override fun onFailure(p0: Call<LoveModel>, failure: Throwable) {
                Log.e("fail", "onFailure: ${failure.message}")
            }
        })
    }
}