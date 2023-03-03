package com.example.composetodo.models

data class ToDoItem(
    var topPriority: Boolean = false,
    var name:String,
    var description:String
)
