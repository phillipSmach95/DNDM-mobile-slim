package com.example.dndmanagerslim.data

data class PlacesData(
    val place_id: Int,
    val name: String ,
    val description: String,
    val quests: List<QuestData> = emptyList(), // Array von QuestData, Standard: leer
)
