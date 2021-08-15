package tornaco.project.android.feedwhen.data.model

import org.junit.Test


internal class OrderDataTest {

    @Test
    fun `given OrderData when convert to order then return Order`() {
        val dataOrder = OrderData("123", 123L)
        val domainOrder = dataOrder.toOrder()
        assert(domainOrder.orderId == "123")
        assert(domainOrder.submitTimeMills == 123L)
    }
}