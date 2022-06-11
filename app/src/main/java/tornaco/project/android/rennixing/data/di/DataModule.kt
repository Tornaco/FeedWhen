package tornaco.project.android.rennixing.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import tornaco.project.android.rennixing.data.repository.OrderRepositoryImpl
import tornaco.project.android.rennixing.domain.repository.OrderRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    @Binds
    @Singleton
    fun bindOrderRepository(forecastRepository: OrderRepositoryImpl): OrderRepository
}
