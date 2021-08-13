package tornaco.project.android.feedwhen.domain.usecase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

abstract class FlowUseCase<PARAM, RESULT> {

    operator fun invoke(param: PARAM): Flow<RESULT> {
        return flow {
            emit(execute(param))
        }
    }

    abstract suspend fun execute(param: PARAM): RESULT
}