package com.example.workshop_tl.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.workshop_tl.R
import com.example.workshop_tl.databinding.ActivityMainBinding
import com.example.workshop_tl.presentation.dashboard.DashboardActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val authViewModel by viewModel<AuthViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerLogin) as NavHostFragment
        val navController = navHostFragment.navController
        navigateToScreen(AuthScreens.LOGIN, navController)


        authViewModel.navToScreen.observe(this) { screen ->
            navigateToScreen(screen, navController)
        }
    }

    private fun navigateToScreen(screen: AuthScreens, navController: NavController) {
        when (screen) {
            AuthScreens.LOGIN -> navController.navigate(R.id.loginFragment)
            AuthScreens.SIGN_UP -> navController.navigate(R.id.signupFragment)
            AuthScreens.LOGIN_SUCCESS -> startActivity(Intent(this, DashboardActivity::class.java))
            // AuthScreens.KYC -> navController.navigate(R.id.kycFragment)
            // AuthScreens.FORGOT_PASSWORD -> navController.navigate(R.id.forgotPasswordFragment)
            else -> {}
        }
    }
}