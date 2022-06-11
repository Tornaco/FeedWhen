package tornaco.project.android.rennixing.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import tornaco.project.android.rennixing.data.model.OrderData

@Dao
interface OrderDao {
    @Query("select * from orders")
    suspend fun getOrders(): List<OrderData>

    @Insert(onConflict = REPLACE)
    suspend fun addOrders(vararg orderData: OrderData)
}