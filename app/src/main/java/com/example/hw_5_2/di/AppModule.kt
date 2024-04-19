package com.example.hw_5_2.di

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.example.hw_5_2.data.local.room.AppDataBase
import com.example.hw_5_2.data.local.room.LoveDao
import com.example.hw_5_2.data.remote.LoveApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideApi(): LoveApi {
        return Retrofit.Builder()
            .baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(LoveApi::class.java)
    }

    @Provides
    fun provideLocalDataBase(@ApplicationContext context: Context): AppDataBase{
        return Room.databaseBuilder(context, AppDataBase::class.java, "love-file")
            .allowMainThreadQueries().build()
    }

    @Provides
    fun provideDao(appDataBase: AppDataBase): LoveDao {
        return appDataBase.getDao()
    }

    @Provides
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("prefs", Context.MODE_PRIVATE)
    }
}