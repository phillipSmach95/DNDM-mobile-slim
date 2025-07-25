package com.example.dndmanagerslim.ui.layout

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dndmanagerslim.view.CharacterViewScreen
import com.example.dndmanagerslim.view.PlaceViewScreen
import com.example.dndmanagerslim.view.QuestViewScreen
import com.example.dndmanagerslim.view.SessionViewScreen
import com.example.dndmanagerslim.viewmodel.CharacterViewModel
import com.example.dndmanagerslim.viewmodel.PlaceViewModel
import com.example.dndmanagerslim.viewmodel.QuestViewModel
import com.example.dndmanagerslim.viewmodel.SessionViewModel

@Composable
fun Navigation(
    characterViewModel: CharacterViewModel,
    sessionViewModel: SessionViewModel,
    placeViewModel: PlaceViewModel,
    questViewModel: QuestViewModel
) {
    val navController = rememberNavController()
    Scaffold(
        topBar = {
            AppTopBar(title = "DND Manager", navController = navController) {
                // Back-Button-Logik, falls benötigt
            }
        },
        modifier = Modifier.statusBarsPadding()
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = "character",
            modifier = Modifier.padding(padding)
        ) {
            composable("character") {
                CharacterViewScreen(viewModel = characterViewModel)
            }
            composable("session") {
                SessionViewScreen(viewModel = sessionViewModel)
            }
            composable("place") {
                PlaceViewScreen(viewModel = placeViewModel)
            }
            composable("quest") {
                QuestViewScreen(viewModel = questViewModel)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(title: String, navController: NavController, onBack: () -> Unit) {
    TopAppBar(
        title = { Text(title) },
        navigationIcon = {
            IconButton(onClick = { onBack() }) {
                Icon(Icons.AutoMirrored.Default.ArrowBack, contentDescription = "Back")
            }
        },
        actions = {
            IconButton(onClick = { navController.navigate("character") }) {
                Icon(Icons.Default.AccountCircle, contentDescription = "Character")
            }
            IconButton(onClick = { navController.navigate("session") }) {
                Icon(Icons.Default.DateRange, contentDescription = "Session")
            }
            IconButton(onClick = { navController.navigate("place") }) {
                Icon(Icons.Default.Place, contentDescription = "Place")
            }
            IconButton(onClick = { navController.navigate("quest") }) {
                Icon(Icons.Default.Info, contentDescription = "Quest")
            }
        }
    )
}