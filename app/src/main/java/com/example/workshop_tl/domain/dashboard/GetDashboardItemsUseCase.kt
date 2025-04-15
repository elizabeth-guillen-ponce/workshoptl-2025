package com.example.workshop_tl.domain.dashboard

import com.example.workshop_tl.domain.common.model.UserType
import com.example.workshop_tl.domain.profile.GetProfileUserUseCase
import com.example.workshop_tl.domain.session.GetUserIdUseCase
import com.example.workshop_tl.presentation.dashboard.ui.main.DashboardItem

class GetDashboardItemsUseCase(
    private val getUserIdUseCase: GetUserIdUseCase,
    private val getProfileUserUseCase: GetProfileUserUseCase
) {

    suspend operator fun invoke(): List<DashboardItem> {
        val userId = getUserIdUseCase.invoke()
        val user = getProfileUserUseCase.invoke(userId)
        val items = mutableListOf<DashboardItem>()
        user.collect {
            it.map {
                items.add(DashboardItem.HeaderItem(it.name, it.lastName))
                items.add(
                    if (it.getTypeUser() == UserType.GOLD)
                        DashboardItem.GoldCard(
                            "**** **** **** 1234",
                            "John Doe",
                            "MM/YY",
                            "123"
                        )
                    else DashboardItem.PromotionCard(
                        "Promoción!!!!",
                        "Obten tu tarjeta gratis"
                    )
                )
            }
        }
        return items
    }
}