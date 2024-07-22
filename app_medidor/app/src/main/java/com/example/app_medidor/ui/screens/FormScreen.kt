package com.example.app_medidor.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.app_medidor.entity.Reading
import com.example.app_medidor.viewmodel.ReadingViewModel

@Composable
fun FormScreen(readingViewModel: ReadingViewModel, navController: NavHostController) {
    var type by remember { mutableStateOf("AGUA") }
    var value by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        TextField(
            value = value,
            onValueChange = { value = it },
            label = { Text("Valor del Medidor") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = date,
            onValueChange = { date = it },
            label = { Text("Fecha") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            RadioButton(
                selected = type == "AGUA",
                onClick = { type = "AGUA" }
            )
            Text(text = "Agua")
            Spacer(modifier = Modifier.width(8.dp))
            RadioButton(
                selected = type == "LUZ",
                onClick = { type = "LUZ" }
            )
            Text(text = "Luz")
            Spacer(modifier = Modifier.width(8.dp))
            RadioButton(
                selected = type == "GAS",
                onClick = { type = "GAS" }
            )
            Text(text = "Gas")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            val reading = Reading(type = type, value = value.toDouble(), date = date)
            readingViewModel.insert(reading)
            navController.navigateUp()
        }) {
            Text(text = "Registrar medición")
        }
    }
}
