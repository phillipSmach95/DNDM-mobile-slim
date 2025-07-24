package com.example.dndmanagerslim.data

data class PlacesData(
    val name: String ,
    val description: String,
    val quests: List<QuestData> = emptyList(), // Array von QuestData, Standard: leer
)
