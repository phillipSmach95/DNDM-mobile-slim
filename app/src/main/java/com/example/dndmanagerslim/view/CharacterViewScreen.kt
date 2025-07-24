package com.example.dndmanagerslim.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.dndmanagerslim.data.Character
import com.example.dndmanagerslim.viewmodel.CharacterViewModel

@Composable
fun CharacterViewScreen(viewModel: CharacterViewModel) {
    // Collect the characters state from the ViewModel
    val characters by viewModel.characters.collectAsState()
    if (characters.isEmpty()) {
        // Display a message if there are no characters
        Text(
            text = "No characters found",
            style = MaterialTheme.typography.bodyLarge,
        )

    } else {
        // Display the list of characters
        Box() {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(characters) { character ->
                    CharacterItem(character)
                }
            }
        }
    }
    // Display the list of characters

}

@Composable
fun CharacterItem(character: Character) {
    // Display character details
    Text(
        text = "Name: ${character.name}",
        style = MaterialTheme.typography.bodyLarge,
        modifier = Modifier.fillMaxSize()
    )
    Text(
        text = "Class: ${character.`class`}",
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.onBackground,
        modifier = Modifier.fillMaxSize()
    )
    // Add more character details as needed
}