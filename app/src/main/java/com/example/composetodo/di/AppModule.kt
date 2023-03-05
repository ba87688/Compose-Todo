package com.example.composetodo.di

import android.app.Application
import com.example.composetodo.network.database.ToDoListDao
import com.example.composetodo.network.database.ToDoListDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideToDoListDatabase(
        context:Application
    ):ToDoListDatabase = ToDoListDatabase.getDatabase(context)

    @Singleton
    @Provides
    fun provideToDoListDao(
        db:ToDoListDatabase
    ):ToDoListDao = db.toDoListDao()


}