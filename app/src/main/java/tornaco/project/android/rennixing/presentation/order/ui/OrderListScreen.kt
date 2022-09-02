package tornaco.project.android.rennixing.presentation.order.ui

import androidx.compose.runtime.Composable
import tornaco.project.android.rennixing.presentation.order.UiState

@Composable
fun OrderListScreen() {

}

@Composable
fun OrderList(state: UiState, onItemClick: (orderId: String) -> Unit) {
    val list = state.orderList
    // Display...

    // Impl on click...
    onItemClick("order-id-123")
}