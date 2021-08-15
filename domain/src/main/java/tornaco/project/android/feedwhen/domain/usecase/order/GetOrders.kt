package tornaco.project.android.feedwhen.domain.usecase.order

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import tornaco.project.android.feedwhen.domain.model.Order
import tornaco.project.android.feedwhen.domain.repository.OrderRepository
import tornaco.project.android.feedwhen.domain.usecase.FlowUseCase
import tornaco.project.android.feedwhen.domain.usecase.Result
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class GetOrders @Inject constructor(
    private val orderRepository: OrderRepository,
    private val context: CoroutineContext,
) :
    FlowUseCase<String, List<Order>>(context) {

    override fun execute(param: String): Flow<Result<List<Order>>> {
        return flow {
            emit(Result.Loading)
            emit(Result.Success(orderRepository.getAllOrders()))
        }
    }
}