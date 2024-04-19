package com.example.hw_5_2.data.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.hw_5_2.data.remote.LoveModel

@Dao
interface LoveDao {
    @Insert
    fun insert(loveModel: LoveModel)

    @Query("SELECT * FROM `love-table` ORDER BY firstName ASC")
    fun getAll(): List<LoveModel>

    @Query("DELETE FROM `love-table` WHERE firstName =:name OR secondName = :name")
    fun deleteByName(name: String)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLover(lover: LoveModel)
}