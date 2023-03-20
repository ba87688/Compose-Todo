package com.example.composetodo.viewmodels

import android.app.Application
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
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
    private val _electionFollowed = MutableLiveData<List<ToDoItem>>()
    val electionFollowed: LiveData<List<ToDoItem>> = _electionFollowed


    var currentItemIndex by mutableStateOf<Int?>(null)
        private set

    fun setCurrentItemIndex(index:Int){
        currentItemIndex = index
    }
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


    val currentToDoList = repository.getToDoListItemsFromDB().asLiveData()

    fun addToDoItem(item: ToDoItem){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                repository.dao.insert(item)

            }
        }

    }


    fun setButtonStatus(status:List<ToDoItem>){
        _electionFollowed.postValue(status)
    }


//    fun getAllList():List<ToDoItem>{
//        return dao.getAllToDoItemsList()
//    }

}