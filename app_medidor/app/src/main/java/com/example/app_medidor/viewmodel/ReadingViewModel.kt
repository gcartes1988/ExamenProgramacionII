package com.example.app_medidor.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app_medidor.entity.Reading
import com.example.app_medidor.repository.ReadingRepository
import kotlinx.coroutines.launch

class ReadingViewModel(private val repository: ReadingRepository) : ViewModel() {
    private val _readings = MutableLiveData<List<Reading>>()
    val readings: LiveData<List<Reading>> get() = _readings

    fun insert(reading: Reading) {
        viewModelScope.launch {
            repository.insert(reading)
            _readings.value = repository.getAllReadings()
        }
    }

    fun getAllReadings() {
        viewModelScope.launch {
            _readings.value = repository.getAllReadings()
        }
    }
}
