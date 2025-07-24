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
    val charisma: Int,
    val strengthModifier: Int = calculateModifier(strength),
    val dexterityModifier: Int = calculateModifier(dexterity),
    val constitutionModifier: Int = calculateModifier(constitution),
    val intelligenceModifier: Int = calculateModifier(intelligence),
    val wisdomModifier: Int = calculateModifier(wisdom),
    val charismaModifier: Int = calculateModifier(charisma)
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