package com.example.dndmanagerslim.data

data class Character(
    val id: String,
    val name: String,
    val `class`: String,
    val level: Int,
    val stats: Stats,
    val hitPoints: Int,
    val equipment: List<String>,
    val skills: Skills,
    val spells: List<Spell>
)

data class Stats(
    val strength: Int,
    val dexterity: Int,
    val constitution: Int,
    val intelligence: Int,
    val wisdom: Int,
    val charisma: Int
)

data class Skills(
    val athletics: Int,
    val acrobatics: Int,
    val stealth: Int,
    val perception: Int,
    val survival: Int,
    val investigation: Int,
    val history: Int,
    val arcana: Int,
    val insight: Int,
    val deception: Int,
    val intimidation: Int,
    val performance: Int,
    val persuasion: Int,
    val religion: Int,
    val nature: Int,
    val medicine: Int
)

data class Spell(
    val name: String,
    val level: Int,
    val school: String
)