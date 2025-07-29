package com.example.dndmanagerslim.components.character

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.dndmanagerslim.components.AppDefaultSearchBar
import com.example.dndmanagerslim.data.Character


@Composable
fun CharacterTable(
    modifier: Modifier = Modifier,
    characterList: List<Character>,
    query: String = "",
    onSearch: (String) -> Unit,
    onQueryChange: (String) -> Unit

) {
   AppDefaultSearchBar(
       modifier = modifier,
       query = query,
       onSearch = onSearch,
       placeholder = {
           Text(
                text = "Search Characters",
                modifier = Modifier
                     .fillMaxWidth()
                     .padding(16.dp)
           )
       },
       onQueryChange = onQueryChange,
       searchResults = {
              // Display the list of characters
              characterList.forEach { character ->
                    Text(
                        text = character.name, // Assuming CharacterData has a 'name' property
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )
              }

       }

   )
}

