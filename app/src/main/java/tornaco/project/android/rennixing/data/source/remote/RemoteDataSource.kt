package tornaco.project.android.rennixing.data.source.remote

import retrofit2.http.GET
import tornaco.project.android.rennixing.data.model.OrderData

interface RemoteDataSource {
    @GET("/orders")
    suspend fun getOrders(): ServerResponse<List<OrderData>>

    @GET("/order-services/{oid}/cancel-ticket")
    suspend fun cancelOrder(orderId: String): ServerResponse<Boolean>
}