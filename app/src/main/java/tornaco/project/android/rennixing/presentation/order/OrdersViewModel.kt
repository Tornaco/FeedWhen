package tornaco.project.android.rennixing.presentation.order

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import tornaco.project.android.rennixing.domain.presenter.order.GetOrders
import tornaco.project.android.rennixing.domain.presenter.successOr
import javax.inject.Inject

class OrdersViewModel @Inject constructor(private val getOrders: GetOrders) : ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState

    fun handleUiAction(uiAction: UiAction) {

    }

    fun fetchAllOrders() {
        viewModelScope.launch {
            getOrders("").collectLatest { result ->
                val orders = result.successOr(listOf())
                _uiState.emit(
                    _uiState.value.copy(
                        orderList = orders,
                        isLoading = false
                    )
                )
            }

        }

    }

}