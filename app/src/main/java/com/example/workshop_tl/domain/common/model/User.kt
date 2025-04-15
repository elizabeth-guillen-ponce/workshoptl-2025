package com.example.workshop_tl.domain.common.model

import com.example.workshop_tl.utils.Gender
import com.google.firebase.firestore.DocumentId

data class User(
    @DocumentId
    val id: String = "",
    val email: String = "",
    val name: String = "",
    val lastName: String = "",
    val gender: String = Gender.UNKNOWN,
    val incoming: Int = 0
) {

    fun getTypeUser(): UserType {
        return if (incoming > 10000) {
            UserType.GOLD
        } else UserType.SILVER
    }
}