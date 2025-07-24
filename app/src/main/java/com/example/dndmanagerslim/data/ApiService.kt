package com.example.dndmanagerslim.data

import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    // Characters endpoints
    @GET("mongodb/characters")
    suspend fun getCharacters(): List<Character>
    @GET("mongodb/characters/{id}")
    suspend fun getCharacterById(@Path("id") id: String): Character
    @POST("mongodb/character")
    suspend fun createCharacter(@Body character: Character): Character
    @PUT("mongodb/character/{id}")
    suspend fun updateCharacter(@Path("id") id: String, @Body character: Character): Character
    @DELETE("mongodb/character/{id}")
    suspend fun deleteCharacter(@Path("id") id: String): Response<Unit>

    // Npcs endpoints
    @GET("mongodb/npcs")
    suspend fun getNpcs(): List<NpcData>
    @GET("mongodb/npcs/{id}")
    suspend fun getNpcById(@Path("id") id: String): NpcData
    @POST("mongodb/npcs")
    suspend fun createNpc(@Body npc: NpcData): NpcData
    @PUT("mongodb/npcs/{id}")
    suspend fun updateNpc(@Path("id") id: String, @Body npc: NpcData): NpcData
    @DELETE("mongodb/npcs/{id}")
    suspend fun deleteNpc(@Path("id") id: String): Response<Unit>

    // Quests endpoints
    @GET("mongodb/quests")
    suspend fun getQuests(): List<QuestData>
    @GET("mongodb/quests/{id}")
    suspend fun getQuestById(@Path("id") id: String): QuestData
    @POST("mongodb/quests")
    suspend fun createQuest(@Body quest: QuestData): QuestData
    @PUT("mongodb/quests/{id}")
    suspend fun updateQuest(@Path("id") id: String, @Body quest: QuestData): QuestData
    @DELETE("mongodb/quests/{id}")
    suspend fun deleteQuest(@Path("id") id: String): Response<Unit>

    // Places endpoints
    @GET("mongodb/places")
    suspend fun getPlaces(): List<PlacesData>
    @GET("mongodb/places/{id}")
    suspend fun getPlaceById(@Path("id") id: String): PlacesData
    @POST("mongodb/places")
    suspend fun createPlace(@Body place: PlacesData): PlacesData
    @PUT("mongodb/places/{id}")
    suspend fun updatePlace(@Path("id") id: String, @Body place: PlacesData): PlacesData
    @DELETE("mongodb/places/{id}")
    suspend fun deletePlace(@Path("id") id: String): Response<Unit>

    // Session endpoints
    @GET("mongodb/sessions")
    suspend fun getSessions(): List<SessionData>
    @GET("mongodb/sessions/{id}")
    suspend fun getSessionById(@Path("id") id: String): SessionData
    @POST("mongodb/sessions")
    suspend fun createSession(@Body session: SessionData): SessionData
    @PUT("mongodb/sessions/{id}")
    suspend fun updateSession(@Path("id") id: String, @Body session: SessionData): SessionData
    @DELETE("mongodb/sessions/{id}")
    suspend fun deleteSession(@Path("id") id: String): Response<Unit>



}
