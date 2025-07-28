package com.example.dndmanagerslim

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import com.example.dndmanagerslim.data.RetrofitClient
import com.example.dndmanagerslim.repository.DndRepository
import com.example.dndmanagerslim.view.Navigation
import com.example.dndmanagerslim.viewmodel.AppViewModel
import com.example.dndmanagerslim.viewmodel.CharacterViewModel
import com.example.dndmanagerslim.viewmodel.AppViewModelFactory
import com.example.dndmanagerslim.viewmodel.HomeViewModel
import com.example.dndmanagerslim.viewmodel.PlaceViewModel
import com.example.dndmanagerslim.viewmodel.QuestViewModel
import com.example.dndmanagerslim.viewmodel.SessionViewModel

class MainActivity : ComponentActivity() {

    private val homeViewModel: HomeViewModel by viewModels {
        AppViewModelFactory(DndRepository(RetrofitClient.apiService))
    }
    private val characterViewModel: CharacterViewModel by viewModels {
        AppViewModelFactory(DndRepository(RetrofitClient.apiService))
    }
    private val sessionViewModel: SessionViewModel by viewModels {
        AppViewModelFactory(DndRepository(RetrofitClient.apiService))
    }
    private val placeViewModel: PlaceViewModel by viewModels {
        AppViewModelFactory(DndRepository(RetrofitClient.apiService))
    }
    private val questViewModel: QuestViewModel by viewModels {
        AppViewModelFactory(DndRepository(RetrofitClient.apiService))
    }
    private val appViewModel: AppViewModel by viewModels {
        AppViewModelFactory(DndRepository(RetrofitClient.apiService))
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme (
                colorScheme = MaterialTheme.colorScheme,
                typography = MaterialTheme.typography,


            ) {
                Navigation(
                    characterViewModel,
                    sessionViewModel,
                    placeViewModel,
                    questViewModel,
                    homeViewModel,
                    appViewModel
                )
            }
        }
    }
}