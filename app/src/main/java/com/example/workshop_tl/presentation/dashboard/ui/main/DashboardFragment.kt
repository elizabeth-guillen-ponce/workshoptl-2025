package com.example.workshop_tl.presentation.dashboard.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.workshop_tl.databinding.FragmentDashboardBinding
import org.koin.androidx.viewmodel.ext.android.activityViewModel

class DashboardFragment : Fragment() {


    lateinit var binding: FragmentDashboardBinding

    private val dashboardViewModel by activityViewModel<DashboardViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerViewDashboard.layoutManager = LinearLayoutManager(requireContext())
        dashboardViewModel.dashboardItem.observe(viewLifecycleOwner) { items ->
            binding.recyclerViewDashboard.adapter = DashboardAdapter(items)
        }
    }

}