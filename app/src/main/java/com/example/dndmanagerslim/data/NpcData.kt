package com.example.dndmanagerslim.data
import java.util.Date

data class NpcData(
    val npc_id: String, // eindeutige ID für den NPC
    val name: String,
    val description: String,
    val appearance: String,
    val personality_Traits: String,
    val backstory: String,
    val status: Stats,
    val role: String,
    val current_quests: List<String> = emptyList(), // Liste von Quest-IDs, die dem NPC zugeordnet sind
    val relationships: List<Relationship> = emptyList(), // Liste von Beziehungen zu anderen NPCs oder Charakteren
    val current_location: String, // Aktuelle Position des NPCs
    val lastSeen: Date, // Letzter bekannter Aufenthaltsort oder Zeitstempel
    val AdditionalInfo: String // Zusätzliche Informationen oder Notizen über den NPC
)

data class Relationship (
    val character_id: String, // ID des Charakteres, dem die Beziehung gehört
    val relationship_type: String, // Art der Beziehung (z.B. Freund, Feind, Verbündeter)
    val notes: String // Beschreibung der Beziehung
)


