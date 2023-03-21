package com.example.composetodo.screens

import android.util.Log
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.example.composetodo.viewmodels.MainViewModel

@Composable
fun ToDoDetail(mainViewModel: MainViewModel) {
        val currentItemIndex = mainViewModel.currentItemIndex
//            Log.d("NEVER", "Navigate: $currentItem")

        LaunchedEffect(key1 = currentItemIndex ){
                if (currentItemIndex!=null){
                        Log.d("NEVER ate", "Navigate: $currentItemIndex")
                        val currentItem  = mainViewModel.getCurrentToDoItem(currentItemIndex)
                        Log.d("NEVER ate", "Navigate: ${currentItem?.name}")


                }
        }
        Text(text = "Detail screen")

}