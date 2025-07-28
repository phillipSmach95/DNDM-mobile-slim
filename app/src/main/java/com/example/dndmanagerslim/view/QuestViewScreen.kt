package com.example.dndmanagerslim.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.dndmanagerslim.data.QuestData
import com.example.dndmanagerslim.viewmodel.QuestViewModel

@Composable
fun QuestViewScreen(
    viewModel: QuestViewModel
) {
   val quests by viewModel.questList.collectAsState()

    LazyColumn (modifier = Modifier.padding(16.dp).height(400.dp)) {
        items(quests.size) { index ->
            QuestItem(quest = quests[index])
        }
    }
}

@Composable
fun QuestItem(
    quest: QuestData
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = quest.title,
                style = MaterialTheme.typography.headlineSmall,
                textAlign = TextAlign.Center
            )
            HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
            Text(
                text = quest.description,
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Start
            )
        }
    }
}
