package com.example.dndmanagerslim.view

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
import com.example.dndmanagerslim.data.SessionData
import com.example.dndmanagerslim.viewmodel.SessionViewModel

@Composable
fun SessionViewScreen(
    viewModel: SessionViewModel
) {
   val sessions by viewModel.sessions.collectAsState()

    LazyColumn {
        items(sessions.size) { index ->
            SessionItem(sessions = sessions[index])
        }
    }
}
@Composable
fun SessionItem(
    sessions: SessionData
) {
    LazyColumn (modifier = Modifier.padding(16.dp).height(400.dp)) {
        item {
            Text(
                text = sessions.notes,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(16.dp)
            )
            Text(
                text = sessions.date.toString(),
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(16.dp)
            )
        }
    }


}