package com.example.workshop_tl.presentation

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.workshop_tl.R
import com.example.workshop_tl.databinding.ActivityMainBinding
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
            askNotificationPermission()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        requestPermissionLauncher
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
            } else if (shouldShowRequestPermissionRationale(Manifest.permission.POST_NOTIFICATIONS)) {
                // TODO: display an educational UI explaining to the user the features that will be enabled
                //       by them granting the POST_NOTIFICATION permission. This UI should provide the user
                //       "OK" and "No thanks" buttons. If the user selects "OK," directly request the permission.
                //       If the user selects "No thanks," allow the user to continue without notifications.
            } else {
                // Directly ask for the permission
                requestPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
            }
        }
    }
}