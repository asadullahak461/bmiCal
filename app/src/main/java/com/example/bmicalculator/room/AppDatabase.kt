package com.example.bmicalculator.room

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities =[data::class], version = 1 )
abstract class AppDatabase : RoomDatabase() {

    abstract fun dao():dao

}




