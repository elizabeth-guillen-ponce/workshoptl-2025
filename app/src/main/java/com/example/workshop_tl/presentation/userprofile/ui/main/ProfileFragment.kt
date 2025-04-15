package com.example.workshop_tl.presentation.userprofile.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.workshop_tl.databinding.FragmentProfileBinding
import com.example.workshop_tl.utils.Gender
import org.koin.androidx.viewmodel.ext.android.activityViewModel
import kotlin.getValue


class ProfileFragment : Fragment() {
    lateinit var binding: FragmentProfileBinding

    private val profileViewModel by activityViewModel<ProfileViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.saveButtonProfile.setOnClickListener {
            profileViewModel.onSaveClicked(
                binding.nameInputProfile.text.toString(),
                binding.lastNameInputProfile.text.toString(),
                if(binding.genderRadioGroupProfile.checkedRadioButtonId == binding.maleRadioButtonProfile.id) Gender.MALE else Gender.FEMALE
            )
        }
    }

}