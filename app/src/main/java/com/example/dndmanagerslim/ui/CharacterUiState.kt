package com.example.dndmanagerslim.ui

import com.example.dndmanagerslim.data.Character
import com.example.dndmanagerslim.data.NpcData


data class CharacterUiState (
    val isLoading: Boolean = false,
    val searchQuery: String = "",
    val errorMessage: String = "",
    val selectedCharacterTab: Int = 0,
    val selectedPlayerCharacterTab: Int = 0,
    val selectedNonPlayerCharacterTab: Int = 0,
    val selectedCharacter: Character = Character(),
    val selectedNpcCharacter: NpcData = NpcData(),
    val characters: List<Character> = emptyList(),
    val npcCharacters: List<NpcData> = emptyList(),
    val filteredCharacters: List<Character> = emptyList(),
    val filteredNpcCharacters: List<NpcData> = emptyList(),
    )
