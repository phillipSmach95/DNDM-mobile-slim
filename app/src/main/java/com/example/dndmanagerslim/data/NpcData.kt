package com.example.dndmanagerslim.data
import com.google.gson.annotations.SerializedName
import java.util.Date

data class NpcData(
    @SerializedName("npc_id") val id: String = "",
    val name: String = "",
    val description: String = "",
    val appearance: String = "",
    @SerializedName("personality_traits") val personalityTraits: String = "",
    val backstory: String = "",
    val status: Stats = Stats(
        strength = 10,
        dexterity = 10,
        constitution = 10,
        intelligence = 10,
        wisdom = 10,
        charisma = 10
    ),
    val role: String = "",
   @SerializedName("current_quests") val currentQuests: List<String> = emptyList(),
    val relationships: List<Relationship> = emptyList(),
    @SerializedName("current_location") val currentLocation: String = "",
    val lastSeen: Date = Date(),
    @SerializedName("AdditionalInfo") val additionalInfo: String = ""
)

data class Relationship (
    @SerializedName("character_id") val npcId: String = "",
    @SerializedName("relationship_type") val relationshipType: String = "",
    val notes: String = ""
)
