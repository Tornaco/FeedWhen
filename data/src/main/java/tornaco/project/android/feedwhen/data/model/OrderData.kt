package tornaco.project.android.feedwhen.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import tornaco.project.android.feedwhen.domain.model.Order

@Entity(tableName = "orders")
data class OrderData(
    @PrimaryKey @ColumnInfo(name = "oid") val orderId: String,
    @ColumnInfo(name = "submit_time_mills") val submitTimeMills: Long,
) {
    fun toOrder(): Order {
        return Order(orderId = orderId, submitTimeMills = submitTimeMills)
    }
}