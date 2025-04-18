package com.example.workshop_tl.domain.dashboard

import android.util.Log
import com.example.workshop_tl.domain.analytics.TrackEventUseCase
import com.example.workshop_tl.domain.common.model.UserType
import com.example.workshop_tl.domain.profile.GetProfileUserUseCase
import com.example.workshop_tl.domain.remoteconfig.GetStringValueRemoteUseCase
import com.example.workshop_tl.domain.session.GetUserIdUseCase
import com.example.workshop_tl.presentation.dashboard.ui.main.DashboardItem
import kotlinx.coroutines.flow.first
import java.util.Locale
import kotlin.random.Random

class GetDashboardItemsUseCase(
    private val getUserIdUseCase: GetUserIdUseCase,
    private val getProfileUserUseCase: GetProfileUserUseCase,
    private val trackEventUseCase: TrackEventUseCase,
    private val getStringValueRemoteUseCase: GetStringValueRemoteUseCase
) {

    suspend operator fun invoke(): List<DashboardItem> {
        val userId = getUserIdUseCase.invoke()
        val user = getProfileUserUseCase.invoke(userId).first()
        val items = mutableListOf<DashboardItem>()
        val remoteConfig = getStringValueRemoteUseCase("user_type")
        Log.d("TAG", "invoke: $remoteConfig")
        items.add(DashboardItem.HeaderItem(user!!.name, user.lastName))
        val currency = Random.nextInt(0, 100000)
        items.add(DashboardItem.Balance("%,d".format(Locale.US, currency)))
        items.add(
            if (user.getTypeUser() == UserType.GOLD) {
                trackEventUseCase("dashboard", mapOf("user_type" to "gold"))
                DashboardItem.GoldCard(
                    "**** **** **** 1234",
                    "John Doe",
                    "MM/YY",
                    "123"
                )
            } else {
                trackEventUseCase("dashboard", mapOf("user_type" to "silver"))
                DashboardItem.SilverCard(
                    "**** **** **** 1234",
                    "John Doe",
                    "MM/YY", "123"
                )
            }
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