package tornaco.project.android.rennixing.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import tornaco.project.android.rennixing.data.source.remote.RemoteDataSource

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    internal object Constant {
        internal const val BASE_URL = "https://api.themoviedb.org/3/"
    }

    @Provides
    fun provideRetrofitBuilder(): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
    }

    @Provides
    fun provideRetrofit(builder: Retrofit.Builder): Retrofit {
        return builder.build()
    }

    @Provides
    fun provideRemoteOrderDataSource(retrofit: Retrofit): RemoteDataSource {
        return retrofit.create(RemoteDataSource::class.java)
    }

}