package tornaco.project.android.rennixing.presentation.order

import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test
import tornaco.project.android.rennixing.domain.model.Order
import tornaco.project.android.rennixing.domain.presenter.Result
import tornaco.project.android.rennixing.domain.presenter.Result.Success
import tornaco.project.android.rennixing.domain.presenter.order.GetOrders
import tornaco.project.android.rennixing.MainCoroutineRule


@ObsoleteCoroutinesApi
@ExperimentalCoroutinesApi
internal class OrdersViewModelTest {
    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @Test
    fun `given success with order list when fetch all orders then uiState should updated with non empty list`() {
        // Given
        val mockUseCase = mockk<GetOrders>(relaxed = false)
        every {
            mockUseCase.invoke(any())
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

        runBlockingTest {
            // When
            viewModel.fetchAllOrders()

            assert(viewModel.uiState.value.orderList.size == 9)
            assert(viewModel.uiState.value.orderList[1].orderId == "222")
            assert(viewModel.uiState.value.isLoading.not())
        }
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
        assert(viewModel.uiState.value.orderList.isEmpty())
    }
}