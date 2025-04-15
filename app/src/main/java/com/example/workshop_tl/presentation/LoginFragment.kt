package com.example.workshop_tl.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.workshop_tl.databinding.FragmentLoginBinding
import org.koin.androidx.viewmodel.ext.android.activityViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {

    lateinit var binding: FragmentLoginBinding
    private val authViewModel by activityViewModel<AuthViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loginButton.setOnClickListener {
            if (validateInputs()) {
                authViewModel.onLoginClicked(
                    binding.emailInputLogin.text.toString(),
                    binding.passwordEditText.text.toString()
                )
            }
        }
        binding.signupLogin.setOnClickListener {
            authViewModel.navToScreen(Screens.SIGN_UP)
        }
    }

    private fun validateInputs(): Boolean {
        if (binding.emailInputLogin.text.toString().isEmpty()) {
            binding.emailInputLogin.error = "Email is required"
            return false
        }
        if (binding.passwordEditText.text.toString().isEmpty()) {
            binding.passwordEditText.error = "Password is required"
            return false
        }
        return true
    }

}