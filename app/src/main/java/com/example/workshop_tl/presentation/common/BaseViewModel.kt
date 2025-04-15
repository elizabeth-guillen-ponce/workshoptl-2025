package com.example.workshop_tl.presentation.common

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.workshop_tl.R
import com.example.workshop_tl.domain.common.model.ErrorMessage
import com.example.workshop_tl.presentation.Screens
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

open class BaseViewModel : ViewModel() {
    private val _navToScreen = MutableLiveData<Screens>()
    val navToScreen: LiveData<Screens> = _navToScreen

    fun launchCatching(
        showErrorSnackbar: (ErrorMessage) -> Unit = {},
        block: suspend CoroutineScope.() -> Unit
    ) =
        viewModelScope.launch(
            CoroutineExceptionHandler { _, throwable ->
                Log.d("BaseViewModel", "launchCatching: $throwable")
                val error = if (throwable.message.isNullOrBlank()) {
                    ErrorMessage.IdError(R.string.generic_error)
                } else {
                    ErrorMessage.StringError(throwable.message!!)
                }
                showErrorSnackbar(error)
            },
            block = block
        )

    fun navToScreen(screens: Screens) {
        _navToScreen.value = screens
    }

}
