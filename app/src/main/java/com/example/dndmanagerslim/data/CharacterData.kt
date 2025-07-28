package com.example.dndmanagerslim.data

import com.google.gson.annotations.SerializedName

data class CharacterListResponse(
    @SerializedName("characters") val characters: List<Character>
)

data class Character(
    @SerializedName("_id") val id: String,
    val name: String,
    val `class`: String,
    val level: Int,
    val stats: Stats,
    @SerializedName("hit_points") val hitPoints: Int,
    val inventory: List<String> = emptyList(),
    val equipment: List<String> = emptyList(),
    val skills: Skills,
    val spells: List<Spell>
)

data class Stats(
    val strength: Int,
    val dexterity: Int,
    val constitution: Int,
    val intelligence: Int,
    val wisdom: Int,
    val charisma: Int,
)

data class Skills(
    val athletics: Int,
    val acrobatics: Int,
    val stealth: Int,
    val perception: Int,
    val insight: Int,
    val persuasion: Int,
    val performance: Int,
    val intimidation: Int,
    val arcana: Int,
    val history: Int,
    val nature: Int,
    val religion: Int,
    val medicine: Int,
    val survival: Int,
    val deception: Int,
    @SerializedName("sleight_of_hand") val sleightOfHand: Int,
    @SerializedName("investigation") val investigation: Int,
    @SerializedName("animal_handling") val animalHandling: Int
)

data class Spell(
    val name: String,
    val level: Int,
    val school: String
)


fun calculateModifier(score: Int): Int {
    return when {
        score < 1 -> -5 // Minimum modifier for scores below 1
        score <= 3 -> -4
        score <= 5 -> -3
        score <= 7 -> -2
        score <= 9 -> -1
        score <= 11 -> 0
        score <= 13 -> 1
        score <= 15 -> 2
        score <= 17 -> 3
        score <= 19 -> 4
        else -> 5 // Maximum modifier for scores above 20
    }
}