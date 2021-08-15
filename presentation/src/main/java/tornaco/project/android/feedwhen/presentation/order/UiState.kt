package tornaco.project.android.feedwhen.presentation.order

import tornaco.project.android.feedwhen.domain.model.Order

data class UiState(val orderList: List<Order> = listOf(), val isLoading: Boolean = false)