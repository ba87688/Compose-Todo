package com.example.composetodo.models

import android.net.Uri
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.composetodo.navigation.jsontypes.JsonNavType
import com.google.gson.Gson


@Entity(tableName = "todolist_table")
data class ToDoItem(
    var topPriority: Boolean = false,
    @PrimaryKey
    var name:String,
    var description:String
){
    override fun toString(): String {
        return Uri.encode(Gson().toJson(this))
    }
}

class ToDoItemArgType: JsonNavType<ToDoItem>(){

    override fun fromJsonParse(value: String): ToDoItem =
        Gson().fromJson(value,ToDoItem::class.java)


    override fun ToDoItem.getJsonParse(): String = Gson().toJson(this)



}
