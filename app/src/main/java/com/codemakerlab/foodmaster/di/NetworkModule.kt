package com.codemakerlab.foodmaster.di

import com.codemakerlab.foodmaster.data.network.FoodRecipesAPI
import com.codemakerlab.foodmaster.utils.Constants
import com.codemakerlab.foodmaster.utils.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideHttpRequest(): OkHttpClient {
        return OkHttpClient.Builder()
                .readTimeout(15, TimeUnit.SECONDS)
                .connectTimeout(15, TimeUnit.SECONDS)
                .build()
    }

    @Singleton
    @Provides
    fun provideConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Singleton
    @Provides
    fun provideRetrofitInstance(
            okHttpClient: OkHttpClient,
            gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(gsonConverterFactory)
                .build()
    }

    @Singleton
    @Provides
    fun provideRecipeAPI(retrofit: Retrofit): FoodRecipesAPI {
        return retrofit.create(FoodRecipesAPI::class.java)
    }

}