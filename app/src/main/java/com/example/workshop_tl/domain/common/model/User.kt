package com.example.workshop_tl.domain.common.model

import com.example.workshop_tl.utils.Gender
import com.google.firebase.firestore.DocumentId

data class User(
    @DocumentId
    val userId: String = "",
    val name: String = "",
    val lastName: String = "",
    val gender: String = Gender.UNKNOWN,
    val income: Double = 0.0
) {

    fun getTypeUser(): UserType {
        return if (income > 50000) {
            UserType.GOLD
        } else UserType.SILVER
    }
}