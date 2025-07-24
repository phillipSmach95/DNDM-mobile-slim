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
    fun getModifier(stat: Int): String {
        return when {
            stat >= 20 -> "+5"
            stat >= 18 -> "+4"
            stat >= 16 -> "+3"
            stat >= 14 -> "+2"
            stat >= 12 -> "+1"
            stat >= 10 -> "0"
            stat >= 8 -> "-1"
            stat >= 6 -> "-2"
            stat >= 4 -> "-3"
            stat >= 2 -> "-4"
            else -> "-5" // Für Werte unter 1
        }
    }
}