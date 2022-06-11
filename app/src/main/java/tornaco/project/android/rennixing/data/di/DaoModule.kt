package tornaco.project.android.rennixing.data.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import tornaco.project.android.rennixing.data.source.local.OrderDao
import tornaco.project.android.rennixing.data.source.local.DBDataSource
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {

    @Provides
    @Singleton
    fun provideOrDataBase(@ApplicationContext context: Context): DBDataSource =
        DBDataSource.getInstance(context)

    @Provides
    @Singleton
    fun provideOrderDao(db: DBDataSource): OrderDao = db.orderDao()
}
