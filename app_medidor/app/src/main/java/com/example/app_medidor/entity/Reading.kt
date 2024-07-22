package com.example.app_medidor.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "reading_table")
data class Reading(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val type: String,
    val value: Double,
    val date: String
)
