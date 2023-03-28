package com.example.composetodo.repository

import com.example.composetodo.models.ToDoItem
import com.example.composetodo.network.database.ToDoListDao
import com.example.politicalpreparedness.network.database.networkBoundResource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ToDoListRepository @Inject constructor(
    val dao: ToDoListDao
) {

    fun getToDoListItemsFromDB() = networkBoundResource(

        query = {
            dao.getAllToDoItemsFlow()
        },
        fetch = {
            withContext(Dispatchers.IO){

            }

        },
        saveFetchResult = {

        }

    )


    suspend fun insert(item: ToDoItem){
        dao.insert(item)
    }
    suspend fun delete(item: ToDoItem){
        withContext(Dispatchers.IO){
            dao.delete(item)
        }
    }







}