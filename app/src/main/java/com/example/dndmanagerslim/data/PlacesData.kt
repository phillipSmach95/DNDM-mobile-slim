package com.example.dndmanagerslim.data

import com.google.gson.annotations.SerializedName

data class PlacesData(
    @SerializedName("_id") val placeId: String, // Eindeutige ID für den Ort
    val name: String,
    val description: String,
    val quests: List<QuestData> = emptyList(), // Array von QuestData, Standard: leer
)
