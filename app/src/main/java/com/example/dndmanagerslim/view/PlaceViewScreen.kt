package com.example.dndmanagerslim.view

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.dndmanagerslim.data.PlacesData
import com.example.dndmanagerslim.viewmodel.PlaceViewModel

@Composable
fun PlaceViewScreen(
    viewModel: PlaceViewModel
) {
    val places by viewModel.places.collectAsState()

    if (places.isEmpty()) {
        // Display a message if there are no places
        Text(
            text = "No places found",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(16.dp)
        )
        return
    }
    LazyColumn (modifier = Modifier.padding(16.dp).height(400.dp)) {
        items(places.size) { index ->
            PlaceItem(place = places[index])
        }
    }
}

@Composable
fun PlaceItem(place: PlacesData) {
    Text(
        text = place.name,
        style = MaterialTheme.typography.bodyLarge,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
}
