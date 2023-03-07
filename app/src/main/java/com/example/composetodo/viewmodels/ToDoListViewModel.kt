package com.example.composetodo.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel

class ToDoListViewModel (
    application: Application
) : AndroidViewModel(application) {


    init {
        Log.d("TAG", ": View model is working! ")

    }


}