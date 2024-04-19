package com.example.hw_5_2.data.remote

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "love-table")
data class LoveModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @SerializedName("fname")
    val firstName: String,
    @SerializedName("sname")
    val secondName: String,
    val percentage: String,
    val result: String
) : Serializable {
    override fun toString(): String {
        return "$firstName + $secondName = $percentage\n $result\n\n"
    }
}