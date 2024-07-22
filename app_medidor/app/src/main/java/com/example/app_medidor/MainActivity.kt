package com.example.app_medidor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.app_medidor.navigation.AppNavGraph
import com.example.app_medidor.ui.theme.App_medidorTheme
import com.example.app_medidor.viewmodel.ReadingViewModel
import com.example.app_medidor.viewmodel.ReadingViewModelFactory

class MainActivity : ComponentActivity() {
    private val readingViewModel: ReadingViewModel by viewModels {
        ReadingViewModelFactory((application as MyApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Llamar a getAllReadings para cargar los datos iniciales
        readingViewModel.getAllReadings()

        setContent {
            App_medidorTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    AppNavGraph(readingViewModel)
                }
            }
        }
    }
}
