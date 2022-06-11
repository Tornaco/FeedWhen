package tornaco.project.android.rennixing.presentation.order.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import tornaco.project.android.rennixing.presentation.order.OrderClickAction
import tornaco.project.android.rennixing.presentation.order.OrdersViewModel
import tornaco.project.android.rennixing.presentation.order.UiState

@Composable
fun OrderListScreen() {
    val viewModel = viewModel<OrdersViewModel>()
    val uiState = viewModel.uiState.collectAsState()

    OrderList(state = uiState.value, onItemClick = {
        viewModel.handleUiAction(OrderClickAction(it))
    })
}

@Composable
fun OrderList(state: UiState, onItemClick: (orderId: String) -> Unit) {
    val list = state.orderList
    // Display...

    // Impl on click...
    onItemClick("order-id-123")
}