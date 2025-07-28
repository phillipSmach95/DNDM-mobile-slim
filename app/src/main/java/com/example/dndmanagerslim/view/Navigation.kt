package com.example.dndmanagerslim.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
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

        modifier = Modifier.statusBarsPadding(),
        topBar = {
            AppTopBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                showMenu = menuExpanded,
                navigateUp = { navController.navigateUp() },
                navigateHome = { navController.navigate(NavigationDestination.HOME.name) },
                handleToggleMenu = { appViewModel.handleMenuClick() }
            )
        },
        ) { padding ->

        Row {


            if (menuExpanded) {
                NavigationRail(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    modifier = Modifier.padding(padding),
                ) {
                    NavigationDestination.entries.forEach { screen ->

                        if (screen != NavigationDestination.HOME) {
                            NavigationRailItem(
                                selected = currentScreen == screen,

                                onClick = { navController.navigate(screen.name) },
                                icon = {
                                    Icon(
                                        imageVector = screen.icon,
                                        contentDescription = stringResource(id = screen.num)
                                    )
                                },
                                label = { Text(text = stringResource(id = screen.num)) },
                            )
                        }
                    }

                }
            }


                NavHost(
                    navController = navController,
                    startDestination = NavigationDestination.HOME.name,
                    modifier = Modifier.padding(padding)
                ) {
                    composable(NavigationDestination.HOME.name) {
                        HomeViewScreen(viewModel = homeViewModel)
                    }
                    composable(NavigationDestination.CHARACTER.name) {
                        CharacterViewScreen(viewModel = characterViewModel)
                    }
                    composable(NavigationDestination.SESSION.name) {
                        SessionViewScreen(viewModel = sessionViewModel)
                    }
                    composable(NavigationDestination.PLACE.name) {
                        PlaceViewScreen(viewModel = placeViewModel)
                    }
                    composable(NavigationDestination.QUEST.name) {
                        QuestViewScreen(viewModel = questViewModel)
                    }
                }

        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    currentScreen: NavigationDestination,
    canNavigateBack: Boolean,
    showMenu: Boolean,
    navigateUp: () -> Unit,
    navigateHome: () -> Unit,
    handleToggleMenu: () -> Unit


    ) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = currentScreen.num).uppercase(),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onPrimary,
                textAlign = TextAlign.Center,

            )
        },
        actions = {
            if (canNavigateBack) {
                IconButton(
                    onClick = navigateUp,
                    modifier = Modifier.padding(8.dp)
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            } else {
                IconButton(
                    onClick = navigateHome,
                    modifier = Modifier.padding(8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Home,
                        contentDescription = stringResource(id = NavigationDestination.HOME.num)
                    )
                }
            }
        },
        navigationIcon = {
            if (!showMenu) {
                IconButton(
                    onClick = { handleToggleMenu() },
                    modifier = Modifier.padding(8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Menu,
                        contentDescription = stringResource(id = NavigationDestination.HOME.num)
                    )
                }
            } else {
                IconButton(
                    onClick = { handleToggleMenu() },
                    modifier = Modifier.padding(8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Close,
                        contentDescription = "Close Menu"
                    )
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