package com.example.app_medidor.ui.screens

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.app_medidor.entity.Reading
import com.example.app_medidor.viewmodel.ReadingViewModel

@Composable
fun MainScreen(readingViewModel: ReadingViewModel, navController: NavHostController) {
    val readings by readingViewModel.readings.observeAsState(emptyList())

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate("form") }) {
                Icon(Icons.Filled.Add, contentDescription = null)
            }
        }
    ) { paddingValues ->
        LazyColumn(
            contentPadding = paddingValues,
            modifier = Modifier.fillMaxSize()
        ) {
            items(readings) { reading ->
                ReadingItem(reading)
            }
        }
    }
}

@Composable
fun ReadingItem(reading: Reading) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = reading.type, modifier = Modifier.weight(1f))
        Text(text = reading.value.toString(), modifier = Modifier.weight(1f))
        Text(text = reading.date, modifier = Modifier.weight(1f))
    }
}
