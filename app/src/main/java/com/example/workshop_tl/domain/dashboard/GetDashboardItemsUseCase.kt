package com.example.workshop_tl.domain.dashboard

import com.example.workshop_tl.domain.analytics.TrackEventUseCase
import com.example.workshop_tl.domain.analytics.TrackUserPropertiesUseCase
import com.example.workshop_tl.domain.common.model.UserType
import com.example.workshop_tl.domain.profile.GetProfileUserUseCase
import com.example.workshop_tl.domain.session.GetUserIdUseCase
import com.example.workshop_tl.presentation.dashboard.ui.main.DashboardItem
import com.example.workshop_tl.utils.Events
import kotlinx.coroutines.flow.first
import java.util.Locale
import kotlin.random.Random

class GetDashboardItemsUseCase(
    private val getUserIdUseCase: GetUserIdUseCase,
    private val getProfileUserUseCase: GetProfileUserUseCase,
    private val trackEventUseCase: TrackEventUseCase,
    private val trackUserPropertiesUseCase: TrackUserPropertiesUseCase
) {

    //Add new Item
    suspend operator fun invoke(): List<DashboardItem> {
        val userId = getUserIdUseCase.invoke()
        val user = getProfileUserUseCase.invoke(userId).first()
        val items = mutableListOf<DashboardItem>()
        items.add(DashboardItem.HeaderItem(user!!.name, user.lastName))
        trackUserPropertiesUseCase.invoke(mapOf(Events.Params.USER_TYPE to user.getTypeUser().name))
        val currency = Random.nextInt(0, 100000)
        items.add(DashboardItem.Balance("%,d".format(Locale.US, currency)))
        items.add(
            if (user.getTypeUser() == UserType.GOLD) {
                trackEventUseCase(Events.Name.DASHBOARD, mapOf(Events.Params.USER_TYPE to "gold"))
                DashboardItem.GoldCard(
                    "**** **** **** 1234", "John Doe", "MM/YY", "123"
                )
            } else {
                trackEventUseCase(Events.Name.DASHBOARD, mapOf(Events.Params.USER_TYPE to "silver"))
                DashboardItem.SilverCard(
                    "**** **** **** 1234", "John Doe", "MM/YY", "123"
                )
            }
        )
        if (user.getTypeUser() == UserType.SILVER) {
            items.add(
                DashboardItem.PromotionCard(
                    "Promoción!!!!", "Obten un prestamo personal de hasta $10,000.00 MXN "
                )
            )
        }
        return items
    }
}
