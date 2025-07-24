package com.example.dndmanagerslim.repository

import com.example.dndmanagerslim.data.ApiService
import com.example.dndmanagerslim.data.Character

class CharacterRepository(private val apiService: ApiService) {

    suspend fun getCharacters(): List<Character> {
        return apiService.getCharacters()
    }
    suspend fun getCharacterById(id: String): Character {
        return apiService.getCharacterById(id)
    }
    suspend fun createCharacter(character: Character): Character {
        return apiService.createCharacter(character)
    }
    suspend fun updateCharacter(id: String, character: Character): Character {
        return apiService.updateCharacter(id, character)
    }
    suspend fun deleteCharacter(id: String) {
        apiService.deleteCharacter(id)
    }

}