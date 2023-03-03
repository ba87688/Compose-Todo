package com.example.composetodo.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.composetodo.models.ToDoItem
import com.example.composetodo.screens.screenelements.ToDoCard

@Composable
fun HomeScreen(){
    var list = mutableListOf<ToDoItem>()
    var item1 = ToDoItem(false,"Ivan", "HO")
    var item2 = ToDoItem(false,"Kevin", "HO")
    list.add(item1)
    list.add(item2)
    ToDoCard(list)
}