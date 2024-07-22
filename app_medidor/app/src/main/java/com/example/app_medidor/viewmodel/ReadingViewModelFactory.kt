package com.example.app_medidor.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.app_medidor.repository.ReadingRepository

class ReadingViewModelFactory(private val repository: ReadingRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ReadingViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ReadingViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
