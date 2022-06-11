package tornaco.project.android.rennixing.domain.repository

import tornaco.project.android.rennixing.domain.model.Order

interface OrderRepository {
    suspend fun getOrders(): List<Order>
    suspend fun cancelOrder(orderId: String): Boolean
}