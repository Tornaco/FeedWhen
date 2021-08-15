package tornaco.project.android.feedwhen.data.source.remote

import retrofit2.http.GET
import tornaco.project.android.feedwhen.data.model.OrderData

interface OrderRemoteDataSource {
    @GET("/orders")
    suspend fun getOrders(): ServerResponse<List<OrderData>>
}