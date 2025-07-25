package com.example.dndmanagerslim.view

import androidx.compose.foundation.layout.fillMaxWidth
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

    LazyColumn {
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
