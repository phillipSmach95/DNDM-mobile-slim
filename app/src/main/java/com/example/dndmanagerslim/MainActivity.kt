package com.example.dndmanagerslim

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.dndmanagerslim.data.RetrofitClient
import com.example.dndmanagerslim.repository.CharacterRepository
import com.example.dndmanagerslim.view.CharacterViewScreen
import com.example.dndmanagerslim.viewmodel.CharacterViewModel
import com.example.dndmanagerslim.viewmodel.CharacterViewModelFactory

class MainActivity : ComponentActivity() {
    private val characterViewModel: CharacterViewModel by viewModels {
        CharacterViewModelFactory(CharacterRepository(RetrofitClient.apiService))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme (
                colorScheme = MaterialTheme.colorScheme,
                typography = MaterialTheme.typography,


            ) {
                Scaffold { innerPadding ->
                    Box (modifier = Modifier.padding(innerPadding).statusBarsPadding()) {
                        CharacterViewScreen(viewModel = characterViewModel)
                    }
                }
            }
        }
    }
}