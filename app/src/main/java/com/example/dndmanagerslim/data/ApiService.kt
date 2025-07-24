package com.example.dndmanagerslim.data

import retrofit2.Response
import retrofit2.http.*

interface ApiService {

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
}
