package tornaco.project.android.rennixing.domain.presenter

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlin.coroutines.CoroutineContext

abstract class FlowPresenter<P, R> constructor(private val context: CoroutineContext) {
    operator fun invoke(param: P): Flow<Result<R>> {
        return execute(param).catch { error ->
            emit(Result.Error(error))
        }.flowOn(context)
    }

    abstract fun execute(param: P): Flow<Result<R>>
}