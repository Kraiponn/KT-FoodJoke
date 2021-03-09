package com.codemakerlab.foodmaster.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.codemakerlab.foodmaster.data.database.RecipesDao
import com.codemakerlab.foodmaster.data.database.RecipesDatabase
import com.codemakerlab.foodmaster.utils.Constants.Companion.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Singleton
    @Provides
    fun provideDataBase(
            @ApplicationContext context: Context
    ): RecipesDatabase {
        return Room.databaseBuilder(
                context,
                RecipesDatabase::class.java,
                DATABASE_NAME
        ).build()
    }

    @Singleton
    @Provides
    fun provideDao(recipesDatabase: RecipesDatabase): RecipesDao {
        return recipesDatabase.recipesDao()
    }

}