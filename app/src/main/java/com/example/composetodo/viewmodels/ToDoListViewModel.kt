package com.example.composetodo.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.room.Insert
import com.example.composetodo.models.ToDoItem
import com.example.composetodo.network.database.ToDoListDao
import javax.inject.Inject

class ToDoListViewModel (
    application: Application
) : AndroidViewModel(application) {


    init {
        Log.d("TAG", ": View model is working! ")

    }


//
//    fun getAllList():List<ToDoItem>{
//        return dao.getAllToDoItemsList()
//    }

}