package com.example.composetodo.models

import android.net.Uri
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.composetodo.navigation.jsontypes.JsonNavType
import com.google.gson.Gson
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "todolist_table")
data class ToDoItem(
//    var topPriority: Boolean = false,
    var topPriority: String = "low",
    @PrimaryKey
    var name:String,
    var description:String,
    var done:Boolean
):Parcelable{
    override fun toString(): String {
        return Uri.encode(Gson().toJson(this))
    }
}

class ToDoItemArgType: JsonNavType<ToDoItem>(){

    override fun fromJsonParse(value: String): ToDoItem =
        Gson().fromJson(value,ToDoItem::class.java)


    override fun ToDoItem.getJsonParse(): String = Gson().toJson(this)



}
