package tornaco.project.android.feedwhen.data.repository

import tornaco.project.android.feedwhen.data.source.remote.OrderRemoteDataSource
import tornaco.project.android.feedwhen.domain.model.Order
import tornaco.project.android.feedwhen.domain.repository.OrderRepository
import javax.inject.Inject

class OrderRepositoryImpl @Inject constructor(private val sourceRemote: OrderRemoteDataSource) : OrderRepository {

    override suspend fun getAllOrders(): List<Order> {
        val resp = sourceRemote.getOrders()
        if (resp.isSuccess()) {
            return resp.data!!.map { it.toOrder() }
        } else {
            throw resp.toServerErrorException()
        }
    }
}