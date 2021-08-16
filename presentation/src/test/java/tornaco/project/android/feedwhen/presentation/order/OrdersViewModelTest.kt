package tornaco.project.android.feedwhen.presentation.order

import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.flow
import org.junit.Test
import tornaco.project.android.feedwhen.domain.model.Order
import tornaco.project.android.feedwhen.domain.usecase.Result
import tornaco.project.android.feedwhen.domain.usecase.Result.Success
import tornaco.project.android.feedwhen.domain.usecase.order.GetOrders


internal class OrdersViewModelTest {

    @Test
    fun `given success with order list when fetch all orders then uiState should updated with non empty list`() {
        // Given
        val mockUseCase = mockk<GetOrders>()
        every {
            mockUseCase.execute(any())
        } returns flow<Result<List<Order>>> {
            emit(Success(listOf(
                Order(orderId = "111", submitTimeMills = 111L),
                Order(orderId = "222", submitTimeMills = 111L),
                Order(orderId = "333", submitTimeMills = 111L),
                Order(orderId = "444", submitTimeMills = 111L),
                Order(orderId = "555", submitTimeMills = 111L),
                Order(orderId = "666", submitTimeMills = 111L),
                Order(orderId = "777", submitTimeMills = 111L),
                Order(orderId = "888", submitTimeMills = 111L),
                Order(orderId = "999", submitTimeMills = 111L),
            )))
        }

        val viewModel = OrdersViewModel(mockUseCase)

        // When
        viewModel.fetchAllOrders()

        assert(viewModel.uiState.value.isLoading.not())
        assert(viewModel.uiState.value.orderList.size == 10)
    }

    @Test
    fun `given fail with order list when fetch all orders then uiState should updated with empty list`() {
        // Given
        val mockUseCase = mockk<GetOrders>()
        every {
            mockUseCase.execute(any())
        } returns flow<Result<List<Order>>> {
            emit(Result.Error(Exception("testing...")))
        }

        val viewModel = OrdersViewModel(mockUseCase)

        // When
        viewModel.fetchAllOrders()

        assert(viewModel.uiState.value.isLoading.not())
        assert(viewModel.uiState.value.orderList.size == 0)
    }
}