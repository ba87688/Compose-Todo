package com.example.composetodo.navigation

const val TODOLIST_ARGUMENT_KEY = "name"
const val TODOLIST_ARGUMENT_KEY2 = "name2"
sealed class Screens (val route:String){
    object HomeScreen: Screens("HomePage")
    object ToDoListAddScreen: Screens("ToDoListAdd")
    object ToDoListDetail: Screens("ToDoListDetail/{$TODOLIST_ARGUMENT_KEY}/{$TODOLIST_ARGUMENT_KEY2}"){
        fun passString(name:String,name2:String):String{
//            return this.route.replace(oldValue = "{$TODOLIST_ARGUMENT_KEY}", newValue = name)
            return "ToDoListDetail/{$name}/{$name2}"
        }


    }
}