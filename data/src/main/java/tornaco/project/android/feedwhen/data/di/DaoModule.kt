package tornaco.project.android.feedwhen.data.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import tornaco.project.android.feedwhen.data.source.local.OrderDao
import tornaco.project.android.feedwhen.data.source.local.OrderDataBase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {

    @Provides
    @Singleton
    fun provideOrDataBase(@ApplicationContext context: Context): OrderDataBase =
        OrderDataBase.getInstance(context)

    @Provides
    @Singleton
    fun provideOrderDao(db: OrderDataBase): OrderDao = db.orderDao()
}
