package tornaco.project.android.rennixing.data.source.remote

import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Before
import org.junit.Test
import tornaco.project.android.rennixing.data.di.NetworkModule
import java.net.HttpURLConnection

internal class OrderRemoteDataSourceTest {

    private lateinit var mockWebServer: MockWebServer

    private lateinit var remoteDataSource: RemoteDataSource

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()

        val networkModule = NetworkModule()
        remoteDataSource =
            networkModule.provideRemoteOrderDataSource(
                networkModule.provideRetrofit(
                    networkModule.provideRetrofitBuilder().baseUrl(mockWebServer.url("/"))
                ))
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
            val actualResponse = remoteDataSource.getOrders()
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
            val actualResponse = remoteDataSource.getOrders()
            // Assert
            assert(actualResponse.isSuccess().not())
            assert(actualResponse.code == 403)
        }
    }
}