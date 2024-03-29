package tornaco.project.android.rennixing.data.source.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import tornaco.project.android.rennixing.data.model.OrderData

@Database(entities = [OrderData::class], version = 1, exportSchema = false)
abstract class DBDataSource : RoomDatabase() {

    abstract fun orderDao(): OrderDao

    companion object {
        private const val DATABASE_NAME = "order-db"

        // For Singleton instantiation
        @Volatile
        private var instance: DBDataSource? = null

        fun getInstance(context: Context): DBDataSource {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): DBDataSource {
            return Room.databaseBuilder(context, DBDataSource::class.java, DATABASE_NAME)
                .build()
        }
    }
}