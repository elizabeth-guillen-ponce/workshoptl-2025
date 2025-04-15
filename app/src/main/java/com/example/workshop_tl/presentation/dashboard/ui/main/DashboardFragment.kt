package com.example.workshop_tl.presentation.dashboard.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.workshop_tl.databinding.FragmentDashboardBinding
import com.example.workshop_tl.domain.common.model.UserType

class DashboardFragment : Fragment() {


    lateinit var binding: FragmentDashboardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerViewDashboard.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewDashboard.adapter = DashboardAdapter(getDashboardItems(UserType.GOLD))
    }

    private fun getDashboardItems(typeUser: UserType) = listOf<DashboardItems>(
        DashboardItems.HeaderItem("Hola", "John Doe"),
        if (typeUser == UserType.GOLD) DashboardItems.GoldCard(
            "**** **** **** 1234",
            "John Doe",
            "MM/YY",
            "123"
        ) else DashboardItems.PromotionCard(
            "Promoción!!!!",
            "Obten tu tarjeta gratis"
        )
    )

}