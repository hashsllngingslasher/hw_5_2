package com.example.hw_5_2.model

import com.google.gson.annotations.SerializedName

data class LoveModel(
    @SerializedName("fname")
    val firstName: String,
    @SerializedName("sname")
    val secondName: String,
    val percentage: String,
    val result: String
)