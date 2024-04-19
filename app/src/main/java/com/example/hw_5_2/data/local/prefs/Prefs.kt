package com.example.hw_5_2.data.local.prefs

import android.content.SharedPreferences
import javax.inject.Inject

class Prefs @Inject constructor(private val prefs: SharedPreferences) {

    fun doneFirstLaunch() {
        prefs.edit().putBoolean("firstLaunch", false).apply()
    }

    fun isFirstLaunch(): Boolean {
        return prefs.getBoolean("firstLaunch", true)
    }
}