package com.example.dndmanagerslim.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dndmanagerslim.data.PlacesData
import com.example.dndmanagerslim.repository.DndRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PlaceViewModel(
    private val repository: DndRepository
) : ViewModel() {
    private val _places = MutableStateFlow<List<PlacesData>>(emptyList())
    val places: StateFlow<List<PlacesData>> = _places.asStateFlow()
    private val _place = MutableStateFlow<PlacesData?>(null)
    val place: StateFlow<PlacesData?> = _place.asStateFlow()

    init {
        fetchPlaces()
    }

    private fun fetchPlaces() {
        viewModelScope.launch {
            try {
                val result = repository.getPlaces()
                _places.value = result
            } catch (e: Exception) {
                // Fehlerbehandlung
                e.printStackTrace()
            }
        }
    }
}