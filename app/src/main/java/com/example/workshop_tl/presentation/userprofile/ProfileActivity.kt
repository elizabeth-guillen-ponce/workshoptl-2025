package com.example.workshop_tl.presentation.userprofile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.workshop_tl.R
import com.example.workshop_tl.databinding.ActivityProfileBinding
import com.example.workshop_tl.presentation.Screens
import com.example.workshop_tl.presentation.dashboard.DashboardActivity
import com.example.workshop_tl.presentation.userprofile.ui.main.ProfileViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.getValue

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding
    private val profileViewModel by viewModel<ProfileViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerProfile) as NavHostFragment
        val navController = navHostFragment.navController
        navigateToScreen(Screens.KYC, navController)

        profileViewModel.navToScreen.observe(this) { screen ->
            navigateToScreen(screen, navController)
        }
    }

    private fun navigateToScreen(screen: Screens, navController: NavController) {
        when (screen) {
            Screens.LOGIN -> navController.navigate(R.id.loginFragment)
            Screens.SIGN_UP -> navController.navigate(R.id.signupFragment)
            Screens.KYC -> navController.navigate(R.id.profileFragment)
            Screens.DASHBOARD -> startActivity(Intent(this, DashboardActivity::class.java))
            else -> {
                finish()
            }
        }
    }
}