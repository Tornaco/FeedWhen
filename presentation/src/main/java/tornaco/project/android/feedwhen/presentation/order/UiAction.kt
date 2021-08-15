package tornaco.project.android.feedwhen.presentation.order

sealed class UiAction

object ReloadOrdersAction : UiAction()
data class OrderClickAction(val orderId: String) : UiAction()