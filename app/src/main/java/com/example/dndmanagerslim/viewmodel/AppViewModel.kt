package com.example.dndmanagerslim.viewmodel


import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

import androidx.lifecycle.viewModelScope
import com.example.dndmanagerslim.repository.DndRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class AppViewModel(
    private val homeViewModel: HomeViewModel,
    private val placeViewModel: PlaceViewModel,
    private val sessionViewModel: SessionViewModel,
    private val characterViewModel: CharacterViewModel,
    private val questViewModel: QuestViewModel,
    private val dndRepository: DndRepository

) : ViewModel() {
    private val _menuExpanded: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val menuExpanded : MutableStateFlow<Boolean> = _menuExpanded

    init {
        // Initialisiere die ViewModels, wenn nötig
        viewModelScope.launch {
            homeViewModel.fetchData()
            placeViewModel.fetchPlaces()
            sessionViewModel.fetchSessions()
            characterViewModel.fetchCharacters()
            questViewModel.fetchQuests()

        }
    }

    // Getter für die einzelnen ViewModels
    fun getHomeViewModel() = homeViewModel
    fun getPlaceViewModel() = placeViewModel
    fun getSessionViewModel() = sessionViewModel
    fun handleMenuClick() {
        _menuExpanded.value = !_menuExpanded.value
    }
}