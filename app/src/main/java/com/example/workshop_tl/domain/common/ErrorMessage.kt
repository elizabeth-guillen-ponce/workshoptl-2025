package com.example.workshop_tl.domain.common

import androidx.annotation.StringRes

sealed class ErrorMessage {
    class StringError(val message: String) : ErrorMessage()
    class IdError(@StringRes val message: Int) : ErrorMessage()
}
