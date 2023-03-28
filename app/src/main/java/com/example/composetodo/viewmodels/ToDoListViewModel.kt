package com.example.composetodo.viewmodels

import android.app.Application
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.*
import com.example.composetodo.models.ToDoItem
import com.example.composetodo.repository.ToDoListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor( application: Application,val repository: ToDoListRepository ) : ViewModel() {

    private val _electionFollowed = MutableLiveData<List<ToDoItem>>()
    val electionFollowed: LiveData<List<ToDoItem>> = _electionFollowed



    //getting current index of list for detail screen

    var currentItemIndex by mutableStateOf<Int?>(null)
        private set
    fun setCurrentItemIndex(index:Int){
        currentItemIndex = index
    }



    //custom dialog popper
    var isDialogShown by mutableStateOf(false)
        private set

    fun onPurchaseClick(){
        isDialogShown = true
    }

    fun onDismissDialog(){
        isDialogShown = false
    }



    fun getCurrentToDoItem(index: Int):ToDoItem?{
        val currentToDoPicked=  _electionFollowed.value?.get(index = index)
        return currentToDoPicked
    }
    fun setButtonStatus(status:List<ToDoItem>){
        _electionFollowed.postValue(status)
    }
    init {


    }


    val currentToDoList = repository.getToDoListItemsFromDB().asLiveData()

    fun addToDoItem(item: ToDoItem){
        viewModelScope.launch {
                repository.insert(item)
        }

    }

    fun update(item: ToDoItem, boolean: Boolean) {
        viewModelScope.launch {
                item.done = boolean
                repository.insert(item)
        }

    }
    fun delete(item: ToDoItem) {
        viewModelScope.launch {
            repository.delete(item)
        }
    }
    fun delete(item: ToDoItem,list: List<ToDoItem>) {
        viewModelScope.launch {
            repository.delete(item)
            setButtonStatus(list)
        }
    }


}