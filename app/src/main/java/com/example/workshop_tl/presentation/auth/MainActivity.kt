package com.example.workshop_tl.presentation.auth

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.workshop_tl.R
import com.example.workshop_tl.databinding.ActivityMainBinding
import com.example.workshop_tl.presentation.Screens
import com.example.workshop_tl.presentation.dashboard.DashboardActivity
import com.example.workshop_tl.presentation.userprofile.ProfileActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val authViewModel by viewModel<AuthViewModel>()

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission(),
    ) { isGranted: Boolean ->
        if (isGranted) {
            // FCM SDK (and your app) can post notifications.
        } else {
            Toast.makeText(this, R.string.permission_denied, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        askNotificationPermission()
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerLogin) as NavHostFragment
        val navController = navHostFragment.navController
        navigateToScreen(Screens.LOGIN, navController)


        authViewModel.navToScreen.observe(this) { screen ->
            navigateToScreen(screen, navController)
        }
    }

    private fun navigateToScreen(screen: Screens, navController: NavController) {
        when (screen) {
            Screens.LOGIN -> navController.navigate(R.id.loginFragment)
            Screens.SIGN_UP -> navController.navigate(R.id.signupFragment)
            Screens.KYC -> startActivity(Intent(this, ProfileActivity::class.java))
            Screens.DASHBOARD -> startActivity(Intent(this, DashboardActivity::class.java))
            // AuthScreens.FORGOT_PASSWORD -> navController.navigate(R.id.forgotPasswordFragment)
            else -> {}
        }
    }


    private fun askNotificationPermission() {
        // This is only necessary for API level >= 33 (TIRAMISU)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) ==
                PackageManager.PERMISSION_GRANTED
            ) {
                // FCM SDK (and your app) can post notifications.
            } else {
                // Directly ask for the permission
                requestPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
            }
        }
    }
}