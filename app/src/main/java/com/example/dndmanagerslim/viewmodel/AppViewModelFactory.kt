package com.example.dndmanagerslim.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dndmanagerslim.repository.DndRepository

@Suppress("UNCHECKED_CAST")
class AppViewModelFactory(
    private val repository: DndRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
       return when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                HomeViewModel(repository) as T
            }
            modelClass.isAssignableFrom(CharacterViewModel::class.java) -> {
                CharacterViewModel(repository) as T
            }
            modelClass.isAssignableFrom(SessionViewModel::class.java) -> {
                SessionViewModel(repository) as T
            }
            modelClass.isAssignableFrom(PlaceViewModel::class.java) -> {
                PlaceViewModel(repository) as T
            }
            modelClass.isAssignableFrom(QuestViewModel::class.java) -> {
                QuestViewModel(repository) as T
            }
            modelClass.isAssignableFrom(AppViewModel::class.java) -> {
                AppViewModel(
                    homeViewModel = HomeViewModel(repository),
                    placeViewModel = PlaceViewModel(repository),
                    sessionViewModel = SessionViewModel(repository),
                    characterViewModel = CharacterViewModel(repository),
                    questViewModel = QuestViewModel(repository),
                    dndRepository = repository
                ) as T
            }
            else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    }
}