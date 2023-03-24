package com.example.composetodo.network.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.composetodo.models.ToDoItem



@Database(entities = [ToDoItem::class], version = 1, exportSchema = false)
abstract class ToDoListDatabase: RoomDatabase() {

    abstract fun toDoListDao():ToDoListDao
    companion object{
        @Volatile
        private var INSTANCE:ToDoListDatabase?= null
        fun getDatabase(context: Context):ToDoListDatabase{
            val tempInstance = INSTANCE
            if (tempInstance!=null){
                return tempInstance

            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ToDoListDatabase::class.java,
                    "todolist_database"
                ).build()
                INSTANCE = instance

                return instance
            }
        }
    }
}