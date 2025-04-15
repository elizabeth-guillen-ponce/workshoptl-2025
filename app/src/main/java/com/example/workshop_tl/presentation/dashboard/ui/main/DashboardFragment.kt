package com.example.workshop_tl.presentation.dashboard.ui.main

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.workshop_tl.R
import com.example.workshop_tl.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {


    lateinit var binding: FragmentDashboardBinding

    companion object {
        fun newInstance() = DashboardFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

}