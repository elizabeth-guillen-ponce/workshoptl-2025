package com.example.workshop_tl.presentation.dashboard.ui.main

import androidx.recyclerview.widget.RecyclerView
import com.example.workshop_tl.databinding.GoldCardItemBinding
import com.example.workshop_tl.databinding.HeaderItemBinding
import com.example.workshop_tl.databinding.PromotionCardItemBinding

class HeaderViewHolder(private val binding: HeaderItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: DashboardItem.HeaderItem) {
        binding.greetingTextHeader.text = item.name
    }
}

class GoldCardViewHolder(private val binding: GoldCardItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: DashboardItem.GoldCard) {
        binding.cardNumberTextCard.text = item.cardNumber
        binding.cardHolderTextCard.text = item.cardHolder
        binding.expiryDateTextCard.text = item.expiryDate
    }
}

class PromotionViewHolder(private val binding: PromotionCardItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: DashboardItem.PromotionCard) {
        binding.titleTextPromotion.text = item.title
        binding.descriptionTextPromotion.text = item.description
    }
}
