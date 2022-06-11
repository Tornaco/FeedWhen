package tornaco.project.android.rennixing.domain.presenter.order

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import tornaco.project.android.rennixing.domain.model.Order
import tornaco.project.android.rennixing.domain.repository.OrderRepository
import tornaco.project.android.rennixing.domain.presenter.FlowPresenter
import tornaco.project.android.rennixing.domain.presenter.Result
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class GetOrders @Inject constructor(
    private val orderRepository: OrderRepository,
    private val context: CoroutineContext,
) :
    FlowPresenter<String, List<Order>>(context) {

    override fun execute(param: String): Flow<Result<List<Order>>> {
        return flow {
            emit(Result.Loading)
            emit(Result.Success(orderRepository.getOrders()))
        }
    }
}