package com.example.dndmanagerslim.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.dndmanagerslim.repository.DndRepository

class HomeViewModel(
    private val repository: DndRepository
) : ViewModel() {
    fun fetchData() {
        Log.d("HomeViewModel", "Fetching data...")
    }

}