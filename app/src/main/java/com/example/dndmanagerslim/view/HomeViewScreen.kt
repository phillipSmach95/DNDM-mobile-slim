package com.example.dndmanagerslim.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.dndmanagerslim.viewmodel.HomeViewModel

@Composable
fun HomeViewScreen(
    modifier: Modifier,
    viewModel: HomeViewModel
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column {
            Icon(
                imageVector = NavigationDestination.HOME.icon,
                contentDescription = "Home Icon",
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Willkommen bei deinem D&D Manager!",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }
    }
}