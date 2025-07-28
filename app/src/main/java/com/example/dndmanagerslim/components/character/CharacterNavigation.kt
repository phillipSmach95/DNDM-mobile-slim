package com.example.dndmanagerslim.components.character

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

enum class CharacterTabs(val index: Int, val title: String) {
    PlayerCharacters(0, "Player Characters"),
    NonPlayerCharacters(1, "Non-Player Characters"),
}

enum class NonPlayerCharacterTabs(val index: Int, val title: String) {
    Overview(0, "Overview"),
    Stats(1, "Stats"),
    Inventory(2, "Inventory"),
    Spells(3, "Spells"),
    Notes(4, "Notes"),
    Quests(5, "Quests"),
}

enum class PlayerCharacterTabs(val index: Int, val title: String) {
    Overview(0, "Overview"),
    Stats(1, "Stats"),
    Inventory(2, "Inventory"),
    Spells(3, "Spells"),
    Notes(4, "Notes")
}



@Composable
fun CharacterNavigation(
    modifier: Modifier = Modifier,
    selectedCharacterTab: Int,
    selectedPlayerCharacterTab: Int,
    selectedNonPlayerCharacterTab: Int,
    handleCharacterTabClick: (Int) -> Unit,
    handlePlayerCharacterTabs: (Int) -> Unit,
    handleNonPlayerCharacterTabs: (Int) -> Unit,
    characterOverview: @Composable () -> Unit = {
        Text(
            text = "Character Overview",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(16.dp)
        )
    },


) {

    Scaffold { innerPadding ->
        Column(
            modifier = modifier.padding(innerPadding)
        ) {
            Row {
                CharacterTabRow(
                    selectedTab = selectedCharacterTab,
                    handleTabClick = handleCharacterTabClick,
                )

            }
            when (selectedCharacterTab) {
                CharacterTabs.PlayerCharacters.index -> {
                    PlayerCharacterScreen(
                        selectedPlayerCharacterTab,
                        handlePlayerCharacterTabs,
                        characterOverview
                    )
                }
                CharacterTabs.NonPlayerCharacters.index -> {
                    NonPlayerCharacterScreen(
                        selectedNonPlayerCharacterTab,
                        handleNonPlayerCharacterTabs
                    )
                }
            }
        }
    }

}

@Composable
fun NonPlayerCharacterScreen(
    selectedNonPlayerCharacterTab: Int,
    handleNonPlayerCharacterTabs: (Int) -> Unit
) {
    NonPlayerCharacterTabsRow(
        selectedTab = selectedNonPlayerCharacterTab, // Placeholder for selected tab
        handleNonPlayerCharacterTabs = handleNonPlayerCharacterTabs
    )
    // Placeholder for Non-Player Character content
    when (selectedNonPlayerCharacterTab) {
        NonPlayerCharacterTabs.Overview.index -> {
            Text(text = "Overview of Non-Player Characters", style = MaterialTheme.typography.bodyLarge)
        }
        NonPlayerCharacterTabs.Stats.index -> {
            Text(text = "Stats of Non-Player Characters", style = MaterialTheme.typography.bodyLarge)
        }
        NonPlayerCharacterTabs.Inventory.index -> {
            Text(text = "Inventory of Non-Player Characters", style = MaterialTheme.typography.bodyLarge)
        }
        NonPlayerCharacterTabs.Spells.index -> {
            Text(text = "Spells of Non-Player Characters", style = MaterialTheme.typography.bodyLarge)
        }
        NonPlayerCharacterTabs.Notes.index -> {
            Text(text = "Notes of Non-Player Characters", style = MaterialTheme.typography.bodyLarge)
        }
        NonPlayerCharacterTabs.Quests.index -> {
            Text(text = "Quests of Non-Player Characters", style = MaterialTheme.typography.bodyLarge)
        }
    }

}

@Composable
fun PlayerCharacterScreen(
    selectedPlayerCharacterTab: Int,
    handlePlayerCharacterTabs: (Int) -> Unit,
    characterOverview: @Composable () -> Unit
) {
    PlayerCharacterTabsRow(
        selectedTab = selectedPlayerCharacterTab, // Placeholder for selected tab
        handlePlayerCharacterTabs = handlePlayerCharacterTabs,
    )
    // Placeholder for Player Character content
    when (selectedPlayerCharacterTab) {
        PlayerCharacterTabs.Overview.index -> {
            characterOverview()
        }
        PlayerCharacterTabs.Stats.index -> {
            Text(text = "Stats of Player Characters", style = MaterialTheme.typography.bodyLarge)
        }
        PlayerCharacterTabs.Inventory.index -> {
            Text(text = "Inventory of Player Characters", style = MaterialTheme.typography.bodyLarge)
        }
        PlayerCharacterTabs.Spells.index -> {
            Text(text = "Spells of Player Characters", style = MaterialTheme.typography.bodyLarge)
        }
        PlayerCharacterTabs.Notes.index -> {
            Text(text = "Notes of Player Characters", style = MaterialTheme.typography.bodyLarge)
        }
    }
}


@Composable
fun CharacterTabRow(
    selectedTab: Int,
    handleTabClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    // Placeholder for Tab Row
    TabRow(
        selectedTabIndex = selectedTab,
        modifier = modifier.padding(8.dp)
    ) {
        CharacterTabs.entries.forEach { tab ->
            Tab(
                selected = selectedTab == tab.ordinal,
                onClick = { handleTabClick(tab.ordinal) },
                text = { Text(text = tab.title) }
            )
        }
    }
}

@Composable
fun NonPlayerCharacterTabsRow(selectedTab: Int, handleNonPlayerCharacterTabs: (Int) -> Unit) {

    TabRow(
        selectedTabIndex = selectedTab,
        modifier = Modifier.padding(8.dp)
    ) {
        NonPlayerCharacterTabs.entries.forEach { tab ->
            Tab(
                selected = selectedTab == tab.ordinal,
                onClick = { handleNonPlayerCharacterTabs(tab.ordinal) },
                text = { Text(text = tab.title) }
            )
        }
    }
}

@Composable
fun PlayerCharacterTabsRow(selectedTab: Int, handlePlayerCharacterTabs: (Int) -> Unit) {
    TabRow(
        selectedTabIndex = selectedTab,
        modifier = Modifier.padding(8.dp)
    ) {
        PlayerCharacterTabs.entries.forEach { tab ->
            Tab(
                selected = selectedTab == tab.ordinal,
                onClick = { handlePlayerCharacterTabs(tab.ordinal) },
                text = { Text(text = tab.title) },

            )
        }
    }
}

@Preview
@Composable
fun CharacterNavigationPreview() {
    var selectedCharacterTab by remember { mutableIntStateOf(0) }
    var selectedPlayerCharacterTab by remember { mutableIntStateOf(0) }
    var selectedNonPlayerCharacterTab by remember { mutableIntStateOf(0) }
     val handleCharacterTabClick: (Int) -> Unit = {
         selectedCharacterTab = it

     }
    val handlePlayerCharacterTabs: (Int) -> Unit = {
        selectedPlayerCharacterTab = it
    }
    val handleNonPlayerCharacterTabs: (Int) -> Unit = {
        selectedNonPlayerCharacterTab = it
    }

    CharacterNavigation(
        selectedCharacterTab = CharacterTabs.PlayerCharacters.index,
        selectedPlayerCharacterTab = PlayerCharacterTabs.Overview.index,
        selectedNonPlayerCharacterTab = NonPlayerCharacterTabs.Overview.index,
        handleCharacterTabClick = handleCharacterTabClick,
        handlePlayerCharacterTabs = handlePlayerCharacterTabs,
        handleNonPlayerCharacterTabs = handleNonPlayerCharacterTabs,
    )
}
