package com.example.workshop_tl.presentation.dashboard.ui.main

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.example.workshop_tl.R
import com.example.workshop_tl.databinding.BalanceItemBinding
import com.example.workshop_tl.databinding.GoldCardItemBinding
import com.example.workshop_tl.databinding.HeaderItemBinding
import com.example.workshop_tl.databinding.PromotionCardItemBinding
import com.example.workshop_tl.databinding.SilverCardItemBinding

class HeaderViewHolder(private val binding: HeaderItemBinding, private val context: Context) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: DashboardItem.HeaderItem) {
        binding.greetingTextHeader.text =
            String.format(context.getString(R.string.greeting), item.name)
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

class SilverCardViewHolder(private val binding: SilverCardItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: DashboardItem.SilverCard) {
        binding.cardNumberTextCard.text = item.cardNumber
        binding.cardHolderTextCard.text = item.cardHolder
        binding.expiryDateTextCard.text = item.expiryDate
    }
}

class BalanceViewHolder(private val binding: BalanceItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: DashboardItem.Balance) {
        binding.balanceLabelBalance.text = item.total
    }
}
