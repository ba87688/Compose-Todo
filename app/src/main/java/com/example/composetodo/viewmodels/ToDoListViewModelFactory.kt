//package com.example.composetodo.viewmodels
//
//import android.app.Application
//import android.os.Bundle
//import androidx.lifecycle.AbstractSavedStateViewModelFactory
//import androidx.lifecycle.SavedStateHandle
//import androidx.lifecycle.ViewModel
//import androidx.savedstate.SavedStateRegistryOwner
//import com.example.composetodo.repository.ToDoListRepository
//import java.lang.IllegalArgumentException
//import javax.inject.Inject
//
//class ToDoListViewModelFactory @Inject constructor(
//    private val application: Application,
//    defaultArgs: Bundle? = null,
//    val repository: ToDoListRepository,
//    savedStateRegistryOwner: SavedStateRegistryOwner
//) : AbstractSavedStateViewModelFactory(savedStateRegistryOwner,defaultArgs) {
//
//
//
//
//    override fun <T : ViewModel?> create(
//        key: String,
//        modelClass: Class<T>,
//        handle: SavedStateHandle
//    ): T {
//        if (modelClass.isAssignableFrom(ToDoListViewModel::class.java)) {
//            return ToDoListViewModel(handle, application,repository) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel Class")
//
//
//
//    }
//
//
//}