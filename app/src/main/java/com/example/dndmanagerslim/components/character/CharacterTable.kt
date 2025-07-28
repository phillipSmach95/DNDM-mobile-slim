package com.example.dndmanagerslim.components.character

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.w3c.dom.CharacterData

@Composable
fun CharacterTable(
    modifier: Modifier = Modifier,
    characterList: List<CharacterData>,
    selectedCharacter: CharacterData,
) {
    // This is a placeholder for the character table UI component.
    // You can implement the UI using Compose components like LazyColumn, Text, etc.
    // For example:
    /*
    LazyColumn {
        items(characterList) { character ->
            Text(text = character.name)
        }
    }
    */
}