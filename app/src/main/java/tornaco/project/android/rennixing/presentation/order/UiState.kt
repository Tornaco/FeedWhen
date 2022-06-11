package tornaco.project.android.rennixing.presentation.order

import tornaco.project.android.rennixing.domain.model.Order

data class UiState(val orderList: List<Order> = listOf(), val isLoading: Boolean = false)