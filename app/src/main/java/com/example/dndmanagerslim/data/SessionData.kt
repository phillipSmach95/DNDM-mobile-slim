package com.example.dndmanagerslim.data

import java.util.Date

data class SessionData(
    val session_id: String, // Eindeutige Sitzungs-ID
    val date: Date, // Datum der Sitzung
    val characters: List<String> = emptyList(), // Array von Charakter-IDs, Standard: leer
    val quests: List<String> = emptyList(), // Array von Quest-IDs, Standard: leer
    val notes: String = "", // Zusätzliche Notizen zur Sitzung
)
