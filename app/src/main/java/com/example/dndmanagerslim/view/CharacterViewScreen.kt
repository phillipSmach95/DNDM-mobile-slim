package com.example.dndmanagerslim.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.dndmanagerslim.data.Character
import com.example.dndmanagerslim.data.Stats
import com.example.dndmanagerslim.viewmodel.CharacterViewModel

@Composable
fun CharacterViewScreen(viewModel: CharacterViewModel) {
    // Fetch characters when the screen is first composed

    // Collect the characters state from the ViewModel
    val characters by viewModel.characters.collectAsState()
    // Collect the characters with modifiers

    if (characters.isEmpty()) {
        // Display a message if there are no characters
        Text(
            text = "No characters found",
            style = MaterialTheme.typography.bodyLarge,
        )

    } else {
        // Display the list of characters
        Box() {
            LazyVerticalGrid(
                columns = GridCells.Fixed(1),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth().padding(10.dp)
            ) {
                items(characters.size) { index ->
                    CharacterItem(
                        character = characters[index],
                        modifier = Modifier,
                        getStatModifier = viewModel::getModifier
                    )
                }
            }
        }
    }
    // Display the list of characters

}

@Composable
fun CharacterItem(character: Character, modifier: Modifier = Modifier , getStatModifier: (Int) -> String) {
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
        modifier = modifier.fillMaxWidth().padding(10.dp)

    ) {
        Column (
            modifier = modifier.fillMaxSize().padding(8.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Text(
                text = character.name,
                style = MaterialTheme.typography.headlineMedium,

                )
            Row(
                modifier = modifier.fillMaxSize().padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Class: ${character.`class`}",
                    style = MaterialTheme.typography.titleLarge,

                    )

                Text(
                    text = "Level: ${character.level}",
                    style = MaterialTheme.typography.titleLarge,

                    )
            }

        }
        HorizontalDivider(
            modifier = modifier.padding(vertical = 8.dp),
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f)
        )
        StatsDisplay(stats = character.stats, modifier = modifier.fillMaxWidth().padding(4.dp), getSateModifier = getStatModifier)

    }

}

@Composable
fun StatsDisplay(stats: Stats, modifier: Modifier = Modifier, getSateModifier: (Int) -> String) {
    val statList = listOf(
        "Strength" to stats.strength,
        "Dexterity" to stats.dexterity,
        "Constitution" to stats.constitution,
        "Intelligence" to stats.intelligence,
        "Wisdom" to stats.wisdom,
        "Charisma" to stats.charisma
    )


    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),

        modifier = modifier

            .height(250.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalArrangement = Arrangement.SpaceBetween,

    ) {
        items(statList.size) {
            Column {
                Text(
                    text = statList[it].first,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = modifier.padding(2.dp),
                )

                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        contentColor = MaterialTheme.colorScheme.onPrimaryContainer

                    ),
                    border = CardDefaults.outlinedCardBorder(
                        true,
                    ),
                    shape = CardDefaults.elevatedShape,
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 4.dp,
                        pressedElevation = 8.dp,
                        focusedElevation = 6.dp,
                        hoveredElevation = 6.dp,
                        draggedElevation = 8.dp,
                        disabledElevation = 0.dp
                    ),
                    modifier = modifier
                        .fillMaxSize(1f)
                        .padding(4.dp)

                ) {

                    Column(
                        modifier.padding(4.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = CenterHorizontally
                    ) {

                        Text(
                            text = "${statList[it].second}",
                            style = MaterialTheme.typography.bodyLarge,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(2.dp)
                        )
                        Text(
                            text = "Mod: ${getSateModifier(statList[it].second)}",
                            style = MaterialTheme.typography.bodyLarge,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(2.dp)
                        )
                    }
                }
            }
        }
    }
}