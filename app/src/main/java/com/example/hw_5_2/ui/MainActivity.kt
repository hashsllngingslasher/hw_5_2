package com.example.hw_5_2.ui

import androidx.appcompat.app.AppCompatActivity
import com.example.hw_5_2.data.local.prefs.Prefs
import android.os.Bundle
import androidx.navigation.findNavController
import com.example.hw_5_2.R
import com.example.hw_5_2.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    @Inject lateinit var prefs: Prefs

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = findNavController(R.id.nav_host_fragment_container)

        if (prefs.isFirstLaunch()) {
            navController.navigate(R.id.onboardingFragment)
            prefs.doneFirstLaunch()
        } else {
            navController.navigate(R.id.sendDataFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}