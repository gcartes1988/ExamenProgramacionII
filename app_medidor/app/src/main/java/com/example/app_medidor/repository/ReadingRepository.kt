package com.example.app_medidor.repository

import com.example.app_medidor.db.ReadingDao
import com.example.app_medidor.entity.Reading

class ReadingRepository(private val readingDao: ReadingDao) {
    suspend fun insert(reading: Reading) {
        readingDao.insert(reading)
    }

    suspend fun getAllReadings(): List<Reading> {
        return readingDao.getAllReadings()
    }
}
