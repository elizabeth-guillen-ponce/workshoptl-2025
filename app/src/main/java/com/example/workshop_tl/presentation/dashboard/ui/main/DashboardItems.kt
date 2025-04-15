package com.example.workshop_tl.presentation.dashboard.ui.main

sealed class DashboardItems {
    data class GoldCard(
        val cardNumber: String,
        val cardHolder: String,
        val expiryDate: String,
        val cvv: String
    ) : DashboardItems()

    data class HeaderItem(
        val title: String,
        val name: String
    ) : DashboardItems()

    data class PromotionCard(
        val title: String,
        val description: String
    ) : DashboardItems()

    enum class ItemType(val value: Int) {
        HEADER(1),
        GOLD_CARD(2),
        PROMOTION_CARD(3)
    }
}
