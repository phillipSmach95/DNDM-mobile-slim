package com.example.dndmanagerslim.repository

import com.example.dndmanagerslim.data.ApiService
import com.example.dndmanagerslim.data.Character
import com.example.dndmanagerslim.data.NpcData
import com.example.dndmanagerslim.data.PlacesData
import com.example.dndmanagerslim.data.QuestData
import com.example.dndmanagerslim.data.SessionData

class CharacterRepository(private val apiService: ApiService) {

    // Character Management Functions
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

    // NPC Management Functions
    suspend fun getNpcs(): List<NpcData> {
        return apiService.getNpcs()
    }
    suspend fun getNpcById(id: String): NpcData {
        return apiService.getNpcById(id)
    }
    suspend fun createNpc(npc: NpcData): NpcData {
        return apiService.createNpc(npc)
    }
    suspend fun updateNpc(id: String, npc: NpcData): NpcData {
        return apiService.updateNpc(id, npc)
    }
    suspend fun deleteNpc(id: String) {
        apiService.deleteNpc(id)
    }

    // Quest Management Functions
    suspend fun getQuests(): List<QuestData> {
        return apiService.getQuests()
    }
    suspend fun getQuestById(id: String): QuestData {
        return apiService.getQuestById(id)
    }
    suspend fun createQuest(quest: QuestData): QuestData {
        return apiService.createQuest(quest)
    }
    suspend fun updateQuest(id: String, quest: QuestData): QuestData {
        return apiService.updateQuest(id, quest)
    }
    suspend fun deleteQuest(id: String) {
        apiService.deleteQuest(id)
    }

    // Places Management Functions
    suspend fun getPlaces(): List<PlacesData> {
        return apiService.getPlaces()
    }
    suspend fun getPlaceById(id: String): PlacesData {
        return apiService.getPlaceById(id)
    }
    suspend fun createPlace(place: PlacesData): PlacesData {
        return apiService.createPlace(place)
    }
    suspend fun updatePlace(id: String, place: PlacesData): PlacesData {
        return apiService.updatePlace(id, place)
    }
    suspend fun deletePlace(id: String) {
        apiService.deletePlace(id)
    }

    // Session Management Functions
    suspend fun getSessions(): List<SessionData> {
        return apiService.getSessions()
    }
    suspend fun getSessionById(id: String): SessionData {
        return apiService.getSessionById(id)
    }
    suspend fun createSession(session: SessionData): SessionData {
        return apiService.createSession(session)
    }
    suspend fun updateSession(id: String, session: SessionData): SessionData {
        return apiService.updateSession(id, session)
    }
    suspend fun deleteSession(id: String) {
        apiService.deleteSession(id)
    }




}