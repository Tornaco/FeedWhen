package tornaco.project.android.feedwhen.domain.repository

import tornaco.project.android.feedwhen.domain.model.Order

interface OrderRepository {
    suspend fun getAllOrders(): List<Order>
}