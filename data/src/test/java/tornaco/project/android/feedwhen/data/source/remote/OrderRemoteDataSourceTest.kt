package tornaco.project.android.feedwhen.data.source.remote

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import tornaco.project.android.feedwhen.data.di.NetworkModule
import java.net.HttpURLConnection

@RunWith(MockitoJUnitRunner::class)
internal class OrderRemoteDataSourceTest {
    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    private lateinit var mockWebServer: MockWebServer

    private lateinit var orderRemoteDataSource: OrderRemoteDataSource

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
        mockWebServer.start()

        orderRemoteDataSource =
            NetworkModule().provideRemoteOrderDataSource(NetworkModule().provideRetrofit())
    }

    @Test
    fun `given success response when get orders then return server response with success`() {
        // Given
        val response = MockResponse()
            .setResponseCode(HttpURLConnection.HTTP_OK)
            .setBody(StubResponseFileReader("order_success_response.json").content)
        mockWebServer.enqueue(response)


        runBlocking {
            // When
            val actualResponse = orderRemoteDataSource.getOrders()
            // Assert
            assert(actualResponse.isSuccess())
            assert(actualResponse.data!!.size == 1)
        }
    }

    @Test
    fun `given 403 response when get orders then return server response with not success`() {
        // Given
        val response = MockResponse()
            .setResponseCode(HttpURLConnection.HTTP_OK)
            .setBody(StubResponseFileReader("order_fail_response.json").content)
        mockWebServer.enqueue(response)


        runBlocking {
            // When
            val actualResponse = orderRemoteDataSource.getOrders()
            // Assert
            assert(actualResponse.isSuccess().not())
            assert(actualResponse.code == 403)
        }
    }
}