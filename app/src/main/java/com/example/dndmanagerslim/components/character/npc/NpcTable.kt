package com.example.dndmanagerslim.components.character.npc

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.dndmanagerslim.data.NpcData

@Composable
fun NpcTable(
    modifier: Modifier = Modifier,
    npcList: List<NpcData>,
    selectedNpc: NpcData,
) {
    // This is a placeholder for the NPC table UI component.
    // You can implement the UI using Compose components like LazyColumn, Text, etc.
    // For example:
    /*
    LazyColumn {
        items(npcList) { npc ->
            Text(text = npc.name)
        }
    }
    */
}