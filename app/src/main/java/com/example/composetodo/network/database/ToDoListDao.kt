package com.example.composetodo.network.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.composetodo.models.ToDoItem


@Dao
interface ToDoListDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(todoitel:ToDoItem)



}