package tornaco.project.android.feedwhen.data.source.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import tornaco.project.android.feedwhen.data.model.OrderData

@Database(entities = [OrderData::class], version = 1, exportSchema = false)
abstract class OrderDataBase : RoomDatabase() {

    abstract fun orderDao(): OrderDao

    companion object {
        private const val DATABASE_NAME = "order-db"

        // For Singleton instantiation
        @Volatile
        private var instance: OrderDataBase? = null

        fun getInstance(context: Context): OrderDataBase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): OrderDataBase {
            return Room.databaseBuilder(context, OrderDataBase::class.java, DATABASE_NAME)
                .build()
        }
    }
}