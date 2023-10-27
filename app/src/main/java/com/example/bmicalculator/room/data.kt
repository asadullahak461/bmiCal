package com.example.bmicalculator.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(indices = [Index(value = ["name"], unique = true)])
data class data(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val weight: Float,
    val height: Float,
    val age: Float,
    val bmi: Float,
    val name: String


)
