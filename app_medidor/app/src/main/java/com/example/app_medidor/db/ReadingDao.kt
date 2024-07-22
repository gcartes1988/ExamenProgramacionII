package com.example.app_medidor.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.app_medidor.entity.Reading

@Dao
interface ReadingDao {
    @Insert
    suspend fun insert(reading: Reading)

    @Query("SELECT * FROM reading_table")
    suspend fun getAllReadings(): List<Reading>
}
