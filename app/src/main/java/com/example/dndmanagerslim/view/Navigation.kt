package com.example.dndmanagerslim.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.dndmanagerslim.R
import com.example.dndmanagerslim.viewmodel.AppViewModel
import com.example.dndmanagerslim.viewmodel.CharacterViewModel
import com.example.dndmanagerslim.viewmodel.HomeViewModel
import com.example.dndmanagerslim.viewmodel.PlaceViewModel
import com.example.dndmanagerslim.viewmodel.QuestViewModel
import com.example.dndmanagerslim.viewmodel.SessionViewModel

enum class NavigationDestination(val num: Int, val icon: ImageVector) {
    HOME(num = R.string.home, Icons.Outlined.Home),
    CHARACTER(num = R.string.character, Icons.Outlined.Person),
    SESSION(num = R.string.session, Icons.Default.DateRange),
    PLACE(num = R.string.place, Icons.Default.Place),
    QUEST(num = R.string.quest, Icons.Default.Info)
}

@Composable
fun Navigation(
    modifier: Modifier,
    characterViewModel: CharacterViewModel,
    sessionViewModel: SessionViewModel,
    placeViewModel: PlaceViewModel,
    questViewModel: QuestViewModel,
    homeViewModel: HomeViewModel,
    appViewModel: AppViewModel
) {
    val navController = rememberNavController()
    val backStackEntry = navController.currentBackStackEntryAsState()
    val currentScreen = NavigationDestination.valueOf(
        backStackEntry.value?.destination?.route ?: NavigationDestination.HOME.name
    )
    val menuExpanded by appViewModel.menuExpanded.collectAsState()
    Scaffold(

        modifier = modifier,
        bottomBar = {
            AppBottomBar(
                modifier = modifier,
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                showMenu = menuExpanded,
                navigateUp = { navController.navigateUp() },
                navigateHome = { navController.navigate(NavigationDestination.HOME.name) },
                navigateTo = { destination: NavigationDestination ->
                    navController.navigate(destination.name)
                }
            )
        },
        topBar = {
            AppTopBar(
                modifier = modifier,
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                showMenu = menuExpanded,
                navigateUp = { navController.navigateUp() },
                navigateHome = { navController.navigate(NavigationDestination.HOME.name) }
            )
        }

        ) { padding ->

        Row {
            Column (
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
                modifier = modifier
                    .padding(padding)
                    .fillMaxWidth(),

            ) {
                NavHost(
                    navController = navController,
                    startDestination = NavigationDestination.HOME.name,
                    modifier = modifier
                ) {
                    composable(NavigationDestination.HOME.name) {
                        HomeViewScreen(modifier = modifier, viewModel = homeViewModel)
                    }
                    composable(NavigationDestination.CHARACTER.name) {
                        CharacterViewScreen(modifier = modifier, viewModel = characterViewModel)
                    }
                    composable(NavigationDestination.SESSION.name) {
                        SessionViewScreen(modifier = modifier, viewModel = sessionViewModel)
                    }
                    composable(NavigationDestination.PLACE.name) {
                        PlaceViewScreen(modifier = modifier, viewModel = placeViewModel)
                    }
                    composable(NavigationDestination.QUEST.name) {
                        QuestViewScreen(modifier = modifier, viewModel = questViewModel)
                    }
                }
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBottomBar(
    modifier: Modifier = Modifier,
    currentScreen: NavigationDestination,
    canNavigateBack: Boolean,
    showMenu: Boolean,
    navigateUp: () -> Unit,
    navigateHome: () -> Unit,
    navigateTo: (NavigationDestination) -> Unit
) {
    BottomAppBar(
        modifier = modifier.fillMaxWidth(),
        contentColor = MaterialTheme.colorScheme.primaryContainer,
        containerColor = MaterialTheme.colorScheme.onPrimaryContainer,
        content = {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier.fillMaxWidth()
            ) {
                NavigationDestination.entries.forEach { screen ->
                    if (screen != NavigationDestination.HOME) {
                        IconButton(
                            onClick = { navigateTo(screen) },
                            colors = IconButtonDefaults.iconButtonColors(
                                contentColor = contentColorFor(MaterialTheme.colorScheme.onPrimaryContainer)
                            )
                        ) {
                            Icon(
                                imageVector = screen.icon,
                                contentDescription = stringResource(id = screen.num)
                            )
                        }
                    }
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    modifier: Modifier,
    currentScreen: NavigationDestination,
    canNavigateBack: Boolean,
    showMenu: Boolean,
    navigateUp: () -> Unit,
    navigateHome: () -> Unit,


    ) {
    TopAppBar(
        modifier = modifier,
        title = {
            Text(text = stringResource(id = currentScreen.num))
        },
        navigationIcon = {

            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                }
            } else {
                IconButton(onClick = navigateHome) {
                    Icon(Icons.Outlined.Home, contentDescription = "Home")
                }
            }
        },

        colors = TopAppBarDefaults.topAppBarColors(
            titleContentColor = MaterialTheme.colorScheme.primary,
            containerColor = MaterialTheme.colorScheme.onPrimaryContainer,
            actionIconContentColor = MaterialTheme.colorScheme.onPrimary,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
        ),

        )
}