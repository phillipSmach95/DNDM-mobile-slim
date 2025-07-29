package com.example.dndmanagerslim.data

import com.google.gson.annotations.SerializedName

data class CharacterListResponse(
    @SerializedName("characters") val characters: List<Character> = emptyList()
)

data class Character(
    @SerializedName("_id") val id: String = "",
    val name: String = "",
    val `class`: String = "",
    val level: Int = 1,
    val stats: Stats = Stats(),
    @SerializedName("hit_points") val hitPoints: Int = 0,
    val inventory: List<String> = emptyList(),
    val equipment: List<String> = emptyList(),
    val skills: Skills = Skills(),
    val spells: List<Spell> = emptyList()
)

data class Stats(
    val strength: Int = 10,
    val dexterity: Int = 10,
    val constitution: Int = 10,
    val intelligence: Int = 10,
    val wisdom: Int = 10,
    val charisma: Int = 10
)

data class Skills(
    val athletics: Int = 0,
    val acrobatics: Int = 0,
    val stealth: Int = 0,
    val perception: Int = 0,
    val insight: Int = 0,
    val persuasion: Int = 0,
    val performance: Int = 0,
    val intimidation: Int = 0,
    val arcana: Int = 0,
    val history: Int = 0,
    val nature: Int = 0,
    val religion: Int = 0,
    val medicine: Int = 0,
    val survival: Int = 0,
    val deception: Int = 0,
    @SerializedName("sleight_of_hand") val sleightOfHand: Int = 0,
    @SerializedName("investigation") val investigation: Int = 0,
    @SerializedName("animal_handling") val animalHandling: Int = 0
)

data class Spell(
    val name: String = "",
    val level: Int = 0,
    val school: String = ""
)


fun calculateModifier(score: Int): Int {
    return ((score - 10) / 2)
}