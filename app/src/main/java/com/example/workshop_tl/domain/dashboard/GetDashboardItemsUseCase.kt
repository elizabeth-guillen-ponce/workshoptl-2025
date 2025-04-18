package com.example.workshop_tl.domain.dashboard

import com.example.workshop_tl.domain.common.model.UserType
import com.example.workshop_tl.domain.profile.GetProfileUserUseCase
import com.example.workshop_tl.domain.session.GetUserIdUseCase
import com.example.workshop_tl.presentation.dashboard.ui.main.DashboardItem
import kotlinx.coroutines.flow.first

class GetDashboardItemsUseCase(
    private val getUserIdUseCase: GetUserIdUseCase,
    private val getProfileUserUseCase: GetProfileUserUseCase
) {

    suspend operator fun invoke(): List<DashboardItem> {
        val userId = getUserIdUseCase.invoke()
        val user = getProfileUserUseCase.invoke(userId).first()
        val items = mutableListOf<DashboardItem>()
        items.add(DashboardItem.HeaderItem(user!!.name, user.lastName))
        items.add(
            if (user.getTypeUser() == UserType.GOLD)
                DashboardItem.GoldCard(
                    "**** **** **** 1234",
                    "John Doe",
                    "MM/YY",
                    "123"
                )
            else DashboardItem.SilverCard(
                "**** **** **** 1234",
                "John Doe",
                "MM/YY", "123"
            )
        )
        if (user.getTypeUser() == UserType.SILVER) {
            items.add(
                DashboardItem.PromotionCard(
                    "Promoción!!!!",
                    "Obten un prestamo personal de hasta $10,000.00 MXN"
                )
            )
        }
        return items
    }

}