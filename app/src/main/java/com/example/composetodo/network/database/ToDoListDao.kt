package com.example.composetodo.network.database

import androidx.room.*
import com.example.composetodo.models.ToDoItem
import kotlinx.coroutines.flow.Flow


@Dao
interface ToDoListDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(todoitem:ToDoItem)

    @Delete
    suspend fun delete(todoItem:ToDoItem)


    @Query("SELECT * FROM todolist_table")
    fun getAllToDoItemsFlow(): Flow<List<ToDoItem>>

    @Query("SELECT * FROM todolist_table")
    fun getAllToDoItemsList(): List<ToDoItem>


}