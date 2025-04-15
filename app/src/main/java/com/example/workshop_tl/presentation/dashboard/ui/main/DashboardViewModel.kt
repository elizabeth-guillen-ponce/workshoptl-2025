package com.example.workshop_tl.presentation.dashboard.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.workshop_tl.domain.dashboard.GetDashboardItemsUseCase
import com.example.workshop_tl.presentation.common.BaseViewModel

class DashboardViewModel(private val getDashboardItemsUseCase: GetDashboardItemsUseCase) :
    BaseViewModel() {

    private val _dashboardItem = MutableLiveData<List<DashboardItem>>()
    val dashboardItem: LiveData<List<DashboardItem>> = _dashboardItem

    init {
        launchCatching {
            val items = getDashboardItemsUseCase()
            _dashboardItem.value = items
        }
    }

}