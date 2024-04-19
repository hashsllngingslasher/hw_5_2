package com.example.hw_5_2.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hw_5_2.data.remote.LoveModel

@Database(entities = [LoveModel::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun getDao(): LoveDao
}