package com.example.workshop_tl.domain.session

class GetUserIdUseCase(private val getCurrentUserUseCase: GetCurrentUserUseCase) {

    suspend operator fun invoke(): String {
        return getCurrentUserUseCase.invoke().uid
    }
}