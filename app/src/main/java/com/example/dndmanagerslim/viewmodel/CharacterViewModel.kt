package com.example.dndmanagerslim.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dndmanagerslim.data.Character
import com.example.dndmanagerslim.data.NpcData
import com.example.dndmanagerslim.repository.DndRepository
import com.example.dndmanagerslim.ui.CharacterUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class CharacterViewModel(private val repository: DndRepository) : ViewModel() {

    private val _uiState = MutableStateFlow(CharacterUiState())
    val uiState: StateFlow<CharacterUiState> = _uiState.asStateFlow()
    init {
        fetchCharacters()
    }
    fun fetchCharacters() {
        viewModelScope.launch {
            try {
                val result = repository.getCharacters().characters
                _uiState.value = _uiState.value.copy(
                    characters = result,
                    filteredCharacters = result // Initialize filtered characters with all characters
                )
                val npcResult = repository.getNpcs()
                _uiState.value = _uiState.value.copy(
                    npcCharacters = npcResult,
                    filteredNpcCharacters = npcResult // Initialize filtered NPCs with all NPCs
                )

            } catch (e: Exception) {
                // Fehlerbehandlung

                e.printStackTrace()
                Log.e("CharacterViewModel", "Error fetching characters: ${e.message}")
            }
        }
    }
    // handle tab clicks
    fun handleCharacterTabClick(tabIndex: Int) {
        _uiState.value = _uiState.value.copy(selectedCharacterTab = tabIndex)
        Log.d("CharacterViewModel", "Selected character tab: $tabIndex")
    }
    fun handlePlayerCharacterTabs(tabIndex: Int) {
        _uiState.value = _uiState.value.copy(selectedPlayerCharacterTab = tabIndex)
        Log.d("CharacterViewModel", "Selected player character tab: $tabIndex")
    }
    fun handleNonPlayerCharacterTabs(tabIndex: Int) {
        _uiState.value = _uiState.value.copy(selectedNonPlayerCharacterTab = tabIndex)
        Log.d("CharacterViewModel", "Selected non-player character tab: $tabIndex")
    }
    // Search-Functions
    fun onSearch(query: String) {
        Log.d("CharacterViewModel", "Search query: $query")
        if (query.isEmpty()) {
            _uiState.value = _uiState.value.copy(filteredCharacters = _uiState.value.characters)
        } else {
            val filtered = _uiState.value.characters.filter { it.name.contains(query, ignoreCase = true) }
            _uiState.value = _uiState.value.copy(filteredCharacters = filtered)
        }
        Log.d("CharacterViewModel", "Filtered characters: ${_uiState.value.filteredCharacters.size}")
    }
    fun handleQueryChange(query: String) {

        _uiState.value = _uiState.value.copy(searchQuery = query)
        Log.d("CharacterViewModel", "Search query changed: $query")
    }
    fun setCharacter(character: Character) {
        _uiState.value = _uiState.value.copy(selectedCharacter = character)
        Log.d("CharacterViewModel", "Selected character: ${character.name}")
    }
    fun setNpcCharacter(npc: NpcData) {
        _uiState.value = _uiState.value.copy(selectedNpcCharacter = npc)
        Log.d("CharacterViewModel", "Selected NPC character: ${npc.name}")
    }


    // utility functions
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
    fun setEmptyCharacter() {
        _uiState.value = _uiState.value.copy(selectedCharacter = Character())
        Log.d("CharacterViewModel", "Set empty character")
    }

    fun setLoading(isLoading: Boolean) {
        _uiState.value = _uiState.value.copy(isLoading = isLoading)
    }

    fun setSearchQuery(query: String) {
        _uiState.value = _uiState.value.copy(searchQuery = query)
    }

    fun setError(message: String) {
        _uiState.value = _uiState.value.copy(errorMessage = message)
    }
}
