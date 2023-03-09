package com.example.composetodo.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import androidx.room.Insert
import com.example.composetodo.models.ToDoItem
import com.example.composetodo.network.database.ToDoListDao
import com.example.composetodo.repository.ToDoListRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

//class ToDoListViewModel @AssistedInject constructor(
//    @Assisted val state: SavedStateHandle,
//    application: Application,
//    val repository: ToDoListRepository
//
//    ) : AndroidViewModel(application) {

@HiltViewModel
class MainViewModel @Inject constructor( application: Application,val repository: ToDoListRepository ) : ViewModel() {

    init {
        Log.d("TAG", ": View model is working! ")




        viewModelScope.launch {
            withContext(Dispatchers.IO) {
//                var l = dao.getAllToDoItemsList()
//                var l = rep.getToDoListItemsFromDB().asLiveData()
                Log.d("TAG", "onCreate: HOMMMMM ")

            }
        }
    }
//
//    fun getAllList():List<ToDoItem>{
//        return dao.getAllToDoItemsList()
//    }

}