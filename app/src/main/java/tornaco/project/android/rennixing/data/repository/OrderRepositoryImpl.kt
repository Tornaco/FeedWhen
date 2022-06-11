package tornaco.project.android.rennixing.data.repository

import tornaco.project.android.rennixing.data.source.remote.RemoteDataSource
import tornaco.project.android.rennixing.domain.model.Order
import tornaco.project.android.rennixing.domain.repository.OrderRepository
import javax.inject.Inject

class OrderRepositoryImpl @Inject constructor(private val sourceRemote: RemoteDataSource) :
    OrderRepository {

    override suspend fun getOrders(): List<Order> {
        val resp = sourceRemote.getOrders()
        if (resp.isSuccess()) {
            return resp.data!!.map { it.toOrder() }
        } else {
            throw resp.toServerErrorException()
        }
    }

    override suspend fun cancelOrder(orderId: String): Boolean {
        val resp = sourceRemote.cancelOrder(orderId)
        if (resp.isSuccess()) {
            return resp.data!!
        } else {
            throw resp.toServerErrorException()
        }
    }
}