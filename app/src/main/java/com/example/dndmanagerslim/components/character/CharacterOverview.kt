package com.example.dndmanagerslim.components.character

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.dndmanagerslim.components.character.npc.NpcTable
import com.example.dndmanagerslim.data.Character
import com.example.dndmanagerslim.data.NpcData
import com.example.dndmanagerslim.data.Stats
import com.example.dndmanagerslim.ui.CharacterUiState
import com.example.dndmanagerslim.view.CharacterItem
import com.example.dndmanagerslim.view.StatsDisplay


@Composable
fun CharacterOverview(
    modifier: Modifier = Modifier,
    uiState: CharacterUiState,
    onSearch: (String) -> Unit,
    onQueryChange: (String) -> Unit,
    onCharacterSelected: (Int) -> Unit,
    getStatModifier: (Int) -> String = { it.toString() } // Default implementation to convert Int to String
) {
    if (uiState.selectedCharacterTab == CharacterTabs.PlayerCharacters.ordinal) {
      CharacterItem(
          character = uiState.selectedCharacter,
          getStatModifier = getStatModifier
      )
    } else if (uiState.selectedCharacterTab == CharacterTabs.NonPlayerCharacters.ordinal) {
        NpcCard(
            npcData = uiState.selectedNpcCharacter,
            modifier = modifier,
            getStatModifier = getStatModifier
        )
    }
}

@Composable
fun NpcCard(npcData: NpcData, modifier: Modifier = Modifier, getStatModifier: (Int) -> String) {
    // Display character details
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp,
            pressedElevation = 8.dp,
            focusedElevation = 6.dp,
            hoveredElevation = 6.dp,
            draggedElevation = 8.dp,
            disabledElevation = 0.dp
        ),
        border = CardDefaults.outlinedCardBorder(true),
        shape = CardDefaults.elevatedShape,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainer,
            contentColor = MaterialTheme.colorScheme.onSecondaryContainer
        ),
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp)

    ) {
        Column (
            modifier = modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = CenterHorizontally
        ) {


            Text(
                text = npcData.name,
                style = MaterialTheme.typography.headlineMedium,

                )
            Row(
                modifier = modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Role: ${npcData.role}",
                    style = MaterialTheme.typography.titleLarge,

                    )

                Text(
                    text = "appearance: ${npcData.appearance}",
                    style = MaterialTheme.typography.titleLarge,

                    )
            }

        }
        HorizontalDivider(
            modifier = modifier.padding(vertical = 8.dp),
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f)
        )
        StatsDisplay(stats = npcData.status, modifier = modifier
            .fillMaxWidth()
            .padding(4.dp), getSateModifier = getStatModifier)

    }

}

