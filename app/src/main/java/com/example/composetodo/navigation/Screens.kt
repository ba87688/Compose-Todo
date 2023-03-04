package com.example.composetodo.navigation

const val TODOLIST_ARGUMENT_KEY = "name"
sealed class Screens (val route:String){
    object HomeScreen: Screens("HomePage")
    object ToDoListAddScreen: Screens("ToDoListAdd")
    object ToDoListDetail: Screens("ToDoListDetail/{$TODOLIST_ARGUMENT_KEY}"){
        fun passString(name:String):String{
            return this.route.replace(oldValue = "{$TODOLIST_ARGUMENT_KEY}", newValue = name)
        }
    }
}