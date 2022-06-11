package tornaco.project.android.rennixing.presentation.order

sealed class UiAction

object ReloadOrdersAction : UiAction()
data class OrderClickAction(val orderId: String) : UiAction()