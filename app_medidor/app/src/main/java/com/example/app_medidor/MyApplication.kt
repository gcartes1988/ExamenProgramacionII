package com.example.app_medidor

import android.app.Application
import androidx.room.Room
import com.example.app_medidor.db.AppDatabase
import com.example.app_medidor.repository.ReadingRepository

class MyApplication : Application() {
    val database: AppDatabase by lazy {
        Room.databaseBuilder(this, AppDatabase::class.java, "app_database").build()
    }
    val repository: ReadingRepository by lazy {
        ReadingRepository(database.readingDao())
    }
}
