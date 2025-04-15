package com.example.workshop_tl.presentation.dashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.example.workshop_tl.R
import com.example.workshop_tl.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerDashboard) as NavHostFragment
        val navController = navHostFragment.navController
        navController.navigate(R.id.dashboardFragment)

    }
}
