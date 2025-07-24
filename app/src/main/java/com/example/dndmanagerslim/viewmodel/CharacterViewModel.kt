package com.example.dndmanagerslim.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dndmanagerslim.data.Character
import com.example.dndmanagerslim.repository.CharacterRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class CharacterViewModel(private val repository: CharacterRepository) : ViewModel() {

    private val _characters = MutableStateFlow<List<Character>>(emptyList())
    val characters: StateFlow<List<Character>> = _characters.asStateFlow()
    private val _character = MutableStateFlow<Character?>(null)
    val character: StateFlow<Character?> = _character.asStateFlow()

    init {
        fetchCharacters()
    }
    fun fetchCharacters() {
        viewModelScope.launch {
            try {
                val result = repository.getCharacters()
                _characters.value = result
            } catch (e: Exception) {
                // Fehlerbehandlung
                e.printStackTrace()
            }
        }
    }
}