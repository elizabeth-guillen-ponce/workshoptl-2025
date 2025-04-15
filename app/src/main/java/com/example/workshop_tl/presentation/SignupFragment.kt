package com.example.workshop_tl.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.workshop_tl.databinding.FragmentSignupBinding
import org.koin.androidx.viewmodel.ext.android.activityViewModel
import kotlin.getValue

/**
 * A simple [Fragment] subclass.
 * Use the [SignupFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SignupFragment : Fragment() {

    lateinit var binding: FragmentSignupBinding
    private val authViewModel by activityViewModel<AuthViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSignupBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.registerButtonSignup.setOnClickListener {
            authViewModel.onSignUpClicked(
                binding.emailInputSignup.text.toString(),
                binding.confirmEmailInputSignup.text.toString(),
                binding.passwordEditTextSignup.text.toString()
            )
        }
    }
}