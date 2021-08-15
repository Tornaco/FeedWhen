package tornaco.project.android.feedwhen.data.repository

import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test
import tornaco.project.android.feedwhen.data.model.OrderData
import tornaco.project.android.feedwhen.data.source.remote.OrderRemoteDataSource
import tornaco.project.android.feedwhen.data.source.remote.ServerErrorException
import tornaco.project.android.feedwhen.data.source.remote.ServerResponse
import tornaco.project.android.feedwhen.domain.model.Order


internal class OrderRepositoryImplTest {

    @Test(expected = ServerErrorException::class /* then */)
    fun `given code 403 when get order then should throw ServerErrorException`() {
        // given
        val mockDs = mockk<OrderRemoteDataSource>()
        coEvery {
            mockDs.getOrders()
        } returns ServerResponse<List<OrderData>>(code = 403, msg = "Token error")
        val repositoryImpl = OrderRepositoryImpl(mockDs)

        // when
        runBlocking {
            repositoryImpl.getAllOrders()
        }
    }

    @Test
    fun `given code 0 and order list data when get order then should return order list`() {
        // given
        val mockDs = mockk<OrderRemoteDataSource>()
        coEvery {
            mockDs.getOrders()
        } returns ServerResponse<List<OrderData>>(code = 0, msg = "Success", data = listOf(
            OrderData(orderId = "123", submitTimeMills = 1000000L),
            OrderData(orderId = "123", submitTimeMills = 1000000L),
            OrderData(orderId = "123", submitTimeMills = 1000000L),
            OrderData(orderId = "123", submitTimeMills = 1000000L),
            OrderData(orderId = "123", submitTimeMills = 1000000L),
            OrderData(orderId = "123", submitTimeMills = 1000000L),
            OrderData(orderId = "123", submitTimeMills = 1000000L),
            OrderData(orderId = "123", submitTimeMills = 1000000L),
            OrderData(orderId = "123", submitTimeMills = 1000000L),
            OrderData(orderId = "123", submitTimeMills = 1000000L),
        ))
        val repositoryImpl = OrderRepositoryImpl(mockDs)

        // when
        runBlocking {
            val orders = repositoryImpl.getAllOrders()

            // then
            assert(orders[0] == Order(orderId = "123", submitTimeMills = 1000000L))
        }
    }
}