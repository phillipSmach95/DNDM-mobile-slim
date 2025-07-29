package com.example.dndmanagerslim.components.character.npc

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.dndmanagerslim.components.AppDefaultSearchBar
import com.example.dndmanagerslim.data.NpcData

@Composable
fun NpcTable(
    modifier: Modifier = Modifier,
    npcList: List<NpcData>,
    query: String = "",
    onSearch: (String) -> Unit,
    onQueryChange: (String) -> Unit
) {
  AppDefaultSearchBar(
      query = query,
      onQueryChange = onQueryChange,
      onSearch = onSearch,
      placeholder = {
            Text(
                text = "Search NPCs",
                modifier = modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        },
      searchResults = {
            // Display the list of NPCs
            npcList.forEach { npc ->
                Text(
                    text = npc.name,
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
            }
      }
  )
}