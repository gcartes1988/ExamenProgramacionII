package com.example.app_medidor.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.app_medidor.entity.Reading

@Database(entities = [Reading::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun readingDao(): ReadingDao
}
