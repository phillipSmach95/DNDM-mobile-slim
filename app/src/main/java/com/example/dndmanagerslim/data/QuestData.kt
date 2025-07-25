package com.example.dndmanagerslim.data

data class QuestData(
    val quest_id: String, // entspricht quest_id, eindeutig
    val title: String,
    val description: String,
    val status: String,
    val reward: String,
    val assignedTo: List<String> = emptyList() // Array von Charakter-IDs, Standard: leer
)
