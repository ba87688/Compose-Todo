package com.example.composetodo.network.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.composetodo.models.ToDoItem
import kotlinx.coroutines.flow.Flow


@Dao
interface ToDoListDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(todoitel:ToDoItem)


    @Query("SELECT * FROM todolist_table")
    fun getAllToDoItemsFlow(): Flow<List<ToDoItem>>

    @Query("SELECT * FROM todolist_table")
    fun getAllToDoItemsList(): List<ToDoItem>


}